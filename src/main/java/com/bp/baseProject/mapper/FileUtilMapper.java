package com.bp.baseProject.mapper;


import com.bp.baseProject.entity.FileEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileUtilMapper {

	int insertBatchImg(List<FileEntity> fileEntity);
	
	int deleteBatchImg(FileEntity fileEntity);

	String getEmailTemplate();

	List<FileEntity> findFileForDataId(String id);

}
