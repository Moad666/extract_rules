package com.humana.bpic.DEPEnrollmentValidation.request;

public class CommunicationPreferences {
	private String preferredWrittenLanguage="";
	private String preferredVerbalLanguage="";
	private String preferredCommunicationMethod="";
	private String preferredAlternateCommunicationFormat="";
	public String getPreferredWrittenLanguage() {
		return preferredWrittenLanguage;
	}
	public void setPreferredWrittenLanguage(String preferredWrittenLanguage) {
		this.preferredWrittenLanguage = preferredWrittenLanguage;
	}
	public String getPreferredVerbalLanguage() {
		return preferredVerbalLanguage;
	}
	public void setPreferredVerbalLanguage(String preferredVerbalLanguage) {
		this.preferredVerbalLanguage = preferredVerbalLanguage;
	}
	public String getPreferredCommunicationMethod() {
		return preferredCommunicationMethod;
	}
	public void setPreferredCommunicationMethod(String preferredCommunicationMethod) {
		this.preferredCommunicationMethod = preferredCommunicationMethod;
	}
	public String getPreferredAlternateCommunicationFormat() {
		return preferredAlternateCommunicationFormat;
	}
	public void setPreferredAlternateCommunicationFormat(String preferredAlternateCommunicationFormat) {
		this.preferredAlternateCommunicationFormat = preferredAlternateCommunicationFormat;
	}


}
