package com.humana.bpic.DEPEnrollmentValidation.request;

//This is part of 124AM rules development
public class ErrorRecord {
	private String errorRecord="";
    private boolean su35=false;
    private Integer errorRecordProcessed=0;
    private Integer snpdCount=0;
    private String errorNumber="";
    private String snpdLongDescription="";
    private String performDiseaseCode="";
    private String attachFlag="";
    private String errorSystemCode="";
    private String outputPreformattedErrorRecord="";
    private String preformatErrorRecord="";
    
	public String getErrorRecord() {
		return errorRecord;
	}
	public void setErrorRecord(String errorRecord) {
		this.errorRecord = errorRecord;
	}
	public boolean isSu35() {
		return su35;
	}
	public void setSu35(boolean su35) {
		this.su35 = su35;
	}
	public Integer getErrorRecordProcessed() {
		return errorRecordProcessed;
	}
	public void setErrorRecordProcessed(Integer errorRecordProcessed) {
		this.errorRecordProcessed = errorRecordProcessed;
	}
	public Integer getSnpdCount() {
		return snpdCount;
	}
	public void setSnpdCount(Integer snpdCount) {
		this.snpdCount = snpdCount;
	}
	public String getErrorNumber() {
		return errorNumber;
	}
	public void setErrorNumber(String errorNumber) {
		this.errorNumber = errorNumber;
	}
	public String getSnpdLongDescription() {
		return snpdLongDescription;
	}
	public void setSnpdLongDescription(String snpdLongDescription) {
		this.snpdLongDescription = snpdLongDescription;
	}
	public String getPerformDiseaseCode() {
		return performDiseaseCode;
	}
	public void setPerformDiseaseCode(String performDiseaseCode) {
		this.performDiseaseCode = performDiseaseCode;
	}
	public String getAttachFlag() {
		return attachFlag;
	}
	public void setAttachFlag(String attachFlag) {
		this.attachFlag = attachFlag;
	}
	public String getErrorSystemCode() {
		return errorSystemCode;
	}
	public void setErrorSystemCode(String errorSystemCode) {
		this.errorSystemCode = errorSystemCode;
	}
	public String getOutputPreformattedErrorRecord() {
		return outputPreformattedErrorRecord;
	}
	public void setOutputPreformattedErrorRecord(String outputPreformattedErrorRecord) {
		this.outputPreformattedErrorRecord = outputPreformattedErrorRecord;
	}
	public String getPreformatErrorRecord() {
		return preformatErrorRecord;
	}
	public void setPreformatErrorRecord(String preformatErrorRecord) {
		this.preformatErrorRecord = preformatErrorRecord;
	}
    
}
