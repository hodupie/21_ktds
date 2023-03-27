package com.hello.common.vo;

public abstract class AbstractVO {
	
	private String FileName;
	private String OriginFileName;
	
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getOriginFileName() {
		return OriginFileName;
	}
	public void setOriginFileName(String originFileName) {
		OriginFileName = originFileName;
	}

}
