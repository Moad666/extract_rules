package com.humana.bpic.DEPEnrollmentValidation.request;

public class ApplicationSignature {

	private String signedBy="";
	private String signedDate="";
	private String applicationSignatureTime="";
	private String applicationSignatureType="";
	private String applicationTelephoneSignatureId="";
	private String applicationTelephoneSignatureVoiceLogId="";
	
	public String getSignedBy() {
		return signedBy;
	}
	public void setSignedBy(String signedBy) {
		this.signedBy = signedBy;
	}
	public String getSignedDate() {
		return signedDate;
	}
	public void setSignedDate(String signedDate) {
		this.signedDate = signedDate;
	}
	public String getApplicationSignatureTime() {
		return applicationSignatureTime;
	}
	public void setApplicationSignatureTime(String applicationSignatureTime) {
		this.applicationSignatureTime = applicationSignatureTime;
	}
	public String getApplicationSignatureType() {
		return applicationSignatureType;
	}
	public void setApplicationSignatureType(String applicationSignatureType) {
		this.applicationSignatureType = applicationSignatureType;
	}
	public String getApplicationTelephoneSignatureId() {
		return applicationTelephoneSignatureId;
	}
	public void setApplicationTelephoneSignatureId(String applicationTelephoneSignatureId) {
		this.applicationTelephoneSignatureId = applicationTelephoneSignatureId;
	}
	public String getApplicationTelephoneSignatureVoiceLogId() {
		return applicationTelephoneSignatureVoiceLogId;
	}
	public void setApplicationTelephoneSignatureVoiceLogId(String applicationTelephoneSignatureVoiceLogId) {
		this.applicationTelephoneSignatureVoiceLogId = applicationTelephoneSignatureVoiceLogId;
	}
	
	
}
