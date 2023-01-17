package com.example.Cocktail_Recipe.domain;

public class FileDto {
	private String uuid; //unique 속성
	private String fileName; //실제 파일 이름
	private String contentType;
	
	public FileDto() {}

	public FileDto(String uuid, String fileName, String contentType) {
		super();
		this.uuid = uuid;
		this.fileName = fileName;
		this.contentType = contentType;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	
}
