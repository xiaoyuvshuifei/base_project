package com.bp.baseProject.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.bp.baseProject.entity.FileEntity;
import com.bp.baseProject.mapper.FileUtilMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Component
public class FileUtil {
	
	@Value("${oss.endpoint}")
	private  String ossEndpoint;  
	
	@Value("${oss.host}")
	private  String ossUrlHost;    //上传文件路径
	
	
	@Value("${oss.accessKeyId}")
	private  String ossAccessKeyId;   
	
	
	@Value("${oss.accessKeySecret}")
	private  String ossAccessKeySecret;   
	
	
	@Value("${oss.bucket}")
	private  String ossBucket;   
	
	@Autowired
	FileUtilMapper fileUtilMapper;
	
	
	private static Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	/**
     * 上传文件至本地
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) { 
        File targetFile = new File(filePath);  
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }       
        FileOutputStream out = null;
		try {
			out = new FileOutputStream(filePath + fileName);
			out.write(file);
			out.flush();
		} catch (FileNotFoundException e) {
			logger.error("uploadFile -- FileNotFoundException" , e);
		} catch (IOException e) {
			logger.error("uploadFile -- IOException" , e);
		}finally{
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					logger.error("uploadFile -- out.close()" , e);
				}
			}
		}
    }
    
    
    /**
     * 上传文件至oss
     * @param uploadOssFilePath	文件路径
     * @param file	上传的文件
     */
    public  boolean uploadMultipartFileOss(String uploadOssFilePath , MultipartFile file) {
    	// Endpoint以杭州为例，其它Region请按实际情况填写。
    	String endpoint = ossEndpoint;
    	// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    	String accessKeyId = ossAccessKeyId;
    	String accessKeySecret = ossAccessKeySecret;

    	// 创建OSSClient实例。
    	OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    	
    	boolean uploadResult = false;
    	// 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
    	try {
			ossClient.putObject(ossBucket, uploadOssFilePath, file.getInputStream());
			uploadResult = true;
		} catch (OSSException e) {
			uploadResult = false;
			logger.error("uploadFileOss -- OSSException" , e);
		} catch (ClientException e) {
			uploadResult = false;
			logger.error("uploadFileOss -- ClientException" , e);
		} catch (IOException e) {
			uploadResult = false;
			logger.error("uploadFileOss -- IOException" , e);
		}finally{
			// 关闭OSSClient。
			ossClient.shutdown();
		}
    	return uploadResult;
    }
    
    
    /**
     * 上传文件至oss
     * @param uploadOssFilePath	文件路径
     * @param file	上传的文件
     */
    public  boolean uploadFileOss(String uploadOssFilePath , File file) {
    	// Endpoint以杭州为例，其它Region请按实际情况填写。
    	String endpoint = ossEndpoint;
    	// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    	String accessKeyId = ossAccessKeyId;
    	String accessKeySecret = ossAccessKeySecret;
    	
    	// 创建OSSClient实例。
    	OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    	
    	boolean uploadResult = false;
    	// 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
    	try {
    		ossClient.putObject(ossBucket, uploadOssFilePath, new FileInputStream(file));
    		file.delete();
    		uploadResult = true;
    	} catch (OSSException e) {
    		uploadResult = false;
    		logger.error("uploadFileOss -- OSSException" , e);
    	} catch (ClientException e) {
    		uploadResult = false;
    		logger.error("uploadFileOss -- ClientException" , e);
    	} catch (IOException e) {
    		uploadResult = false;
    		logger.error("uploadFileOss -- IOException" , e);
    	}finally{
    		// 关闭OSSClient。
    		ossClient.shutdown();
    	}
    	return uploadResult;
    }
    
    
    public  void deleteFileOss(String uploadOssFilePath){
    	// Endpoint以杭州为例，其它Region请按实际情况填写。
    	String endpoint = ossEndpoint;
    	// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    	String accessKeyId = ossAccessKeyId;
    	String accessKeySecret = ossAccessKeySecret;
    	String bucketName = ossBucket;
    	String objectName = uploadOssFilePath;

    	// 创建OSSClient实例。
    	OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

    	// 删除文件。
    	ossClient.deleteObject(bucketName, objectName);

    	// 关闭OSSClient。
    	ossClient.shutdown();
    }
    
    public String uploadFileUtil(MultipartFile file , String uploadOssFilePath) {
    	String fileOriginalName = file.getOriginalFilename();
    	String suffix = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
    	String fileName = UUID.randomUUID().toString();
    	String fileFullName = uploadOssFilePath + fileName + suffix;
    	boolean uploadResult = uploadMultipartFileOss(fileFullName , file);
    	if(!uploadResult) {
    		return "uploadFailed";
    	}
    	return ossUrlHost + fileFullName;
    }


	public File multipartFileToFile(MultipartFile file) {
		try {
			String fileName = file.getOriginalFilename();
			// 获取文件后缀
			String prefix = fileName.substring(fileName.lastIndexOf("."));
			// 用uuid作为文件名，防止生成的临时文件重复
			final File pdfFile = File.createTempFile("发票信息"+DateUtil.parseDateToStr(new Date(),DateUtil.DATE_FORMAT_YYYY_MM_DD), prefix);
			// MultipartFile to File
			file.transferTo(pdfFile);
			return pdfFile;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 删除
	 *
	 * @param files
	 */
	public void deleteFile(File... files) {
		for (File file : files) {
			if (file.exists()) {
				file.delete();
			}
		}
	}


	public int insertBatchImg(List<FileEntity> fileEntities) {
    	int flag = fileUtilMapper.insertBatchImg(fileEntities);
    	return flag;
    }
    
    public int deleteBatchImg(FileEntity fileEntity) {
    	int flag = fileUtilMapper.deleteBatchImg(fileEntity);
    	return flag;
    }

}
