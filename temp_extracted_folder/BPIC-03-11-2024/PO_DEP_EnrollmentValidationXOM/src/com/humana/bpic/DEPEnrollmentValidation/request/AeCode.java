package com.humana.bpic.DEPEnrollmentValidation.request;

import java.util.List;

//This is part of 124AM rules development
public class AeCode {
	private List<String> aeCode;
    private boolean noMorePerformatErrorsFlag= false;
    private String aeCodePlatformValue="";
    private String ws03su65Error="";
    private String platformCode="";
    private boolean ws03su10Error=false;
    private boolean ws03su32Error=false;
    private String aeCodeValue="";
    
	public List<String> getAeCode() {
		return aeCode;
	}
	public void setAeCode(List<String> aeCode) {
		this.aeCode = aeCode;
	}
	public boolean isNoMorePerformatErrorsFlag() {
		return noMorePerformatErrorsFlag;
	}
	public void setNoMorePerformatErrorsFlag(boolean noMorePerformatErrorsFlag) {
		this.noMorePerformatErrorsFlag = noMorePerformatErrorsFlag;
	}
	public String getAeCodePlatformValue() {
		return aeCodePlatformValue;
	}
	public void setAeCodePlatformValue(String aeCodePlatformValue) {
		this.aeCodePlatformValue = aeCodePlatformValue;
	}
	public String getWs03su65Error() {
		return ws03su65Error;
	}
	public void setWs03su65Error(String ws03su65Error) {
		this.ws03su65Error = ws03su65Error;
	}
	public String getPlatformCode() {
		return platformCode;
	}
	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}
	public boolean isWs03su10Error() {
		return ws03su10Error;
	}
	public void setWs03su10Error(boolean ws03su10Error) {
		this.ws03su10Error = ws03su10Error;
	}
	public boolean isWs03su32Error() {
		return ws03su32Error;
	}
	public void setWs03su32Error(boolean ws03su32Error) {
		this.ws03su32Error = ws03su32Error;
	}
	public String getAeCodeValue() {
		return aeCodeValue;
	}
	public void setAeCodeValue(String aeCodeValue) {
		this.aeCodeValue = aeCodeValue;
	}
}
