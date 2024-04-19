package com.humana.bpic.DEPEnrollmentValidation.request;

//This is part of 124AM rules development
public class ErrorHandling {
    private SystemsFiller systemesFiller;
    private AeCode aeCode;
    private ErrorRecord errorRecord;
    private Ae409 ae409;
    
	public SystemsFiller getSystemesFiller() {
		return systemesFiller;
	}
	public void setSystemesFiller(SystemsFiller systemesFiller) {
		this.systemesFiller = systemesFiller;
	}
	public AeCode getAeCode() {
		return aeCode;
	}
	public void setAeCode(AeCode aeCode) {
		this.aeCode = aeCode;
	}
	public ErrorRecord getErrorRecord() {
		return errorRecord;
	}
	public void setErrorRecord(ErrorRecord errorRecord) {
		this.errorRecord = errorRecord;
	}
	public Ae409 getAe409() {
		return ae409;
	}
	public void setAe409(Ae409 ae409) {
		this.ae409 = ae409;
	}
}
