package com.bp.baseProject.entity;

public class FileEntity extends BaseModel{

	/**
	 * 关联数据id  uuid
	 */
	private String dataId;
	/**
	 * 文件名
	 */
	private String fileName;
	/**
	 * 文件url
	 */
	private String fileUrl;
	/**
	 * 状态
	 */
	private int status;


	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
