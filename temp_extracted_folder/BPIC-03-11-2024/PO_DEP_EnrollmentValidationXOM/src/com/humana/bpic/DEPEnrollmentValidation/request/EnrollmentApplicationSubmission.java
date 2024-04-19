package com.humana.bpic.DEPEnrollmentValidation.request;

import java.util.List;

public class EnrollmentApplicationSubmission {
	private String applicationEnrollmentSourceCode="";
	private String applicationSubmittedId="";
	private String applicationProposedEffectiveDate="";
	private String applicationSubmittedTimestamp="";
	private String applicationType="";
	private String electionType="";
	private SpecialElectionPeriodException specialElectionPeriodException;
	private String scopeOfAppointmentId="";
	private String scopeOfAppointmentSource="";
	private String marketReceivedTimestamp="";
	//Added below attributes on 02/01/2024 for the DEP_Iterarion4.4
	private List<String> enrollmentSystemCodes;
	private String onlineEnrollmentCenterConfirmationId="";
	private ApplicationSignature applicationSignature;
	private String documentControlNumber="";
	private String scopeOfAppointmentLocationType="";
	private FileInformation fileInformation;
	private String coverageTerminationDate="";
	//This is a part of 124AM rules development
	private String submitDate="";
    private String submitYear="";
    private String enrollmentPlanYear="";
    private String submitMonth="";
	
	public String getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
	public String getSubmitYear() {
		return submitYear;
	}
	public void setSubmitYear(String submitYear) {
		this.submitYear = submitYear;
	}
	public String getEnrollmentPlanYear() {
		return enrollmentPlanYear;
	}
	public void setEnrollmentPlanYear(String enrollmentPlanYear) {
		this.enrollmentPlanYear = enrollmentPlanYear;
	}
	public String getSubmitMonth() {
		return submitMonth;
	}
	public void setSubmitMonth(String submitMonth) {
		this.submitMonth = submitMonth;
	}
	public String getApplicationEnrollmentSourceCode() {
		return applicationEnrollmentSourceCode;
	}
	public void setApplicationEnrollmentSourceCode(String applicationEnrollmentSourceCode) {
		this.applicationEnrollmentSourceCode = applicationEnrollmentSourceCode;
	}
	public String getApplicationSubmittedId() {
		return applicationSubmittedId;
	}
	public void setApplicationSubmittedId(String applicationSubmittedId) {
		this.applicationSubmittedId = applicationSubmittedId;
	}
	public String getApplicationProposedEffectiveDate() {
		return applicationProposedEffectiveDate;
	}
	public void setApplicationProposedEffectiveDate(String applicationProposedEffectiveDate) {
		this.applicationProposedEffectiveDate = applicationProposedEffectiveDate;
	}
	
	public String getApplicationSubmittedTimestamp() {
		return applicationSubmittedTimestamp;
	}
	public void setApplicationSubmittedTimestamp(String applicationSubmittedTimestamp) {
		this.applicationSubmittedTimestamp = applicationSubmittedTimestamp;
	}
	public String getApplicationType() {
		return applicationType;
	}
	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	public String getElectionType() {
		return electionType;
	}
	public void setElectionType(String electionType) {
		this.electionType = electionType;
	}
	public SpecialElectionPeriodException getSpecialElectionPeriodException() {
		return specialElectionPeriodException;
	}
	public void setSpecialElectionPeriodException(SpecialElectionPeriodException specialElectionPeriodException) {
		this.specialElectionPeriodException = specialElectionPeriodException;
	}
	
	public String getScopeOfAppointmentId() {
		return scopeOfAppointmentId;
	}
	public void setScopeOfAppointmentId(String scopeOfAppointmentId) {
		this.scopeOfAppointmentId = scopeOfAppointmentId;
	}
	public String getScopeOfAppointmentSource() {
		return scopeOfAppointmentSource;
	}
	public void setScopeOfAppointmentSource(String scopeOfAppointmentSource) {
		this.scopeOfAppointmentSource = scopeOfAppointmentSource;
	}
	public String getMarketReceivedTimestamp() {
		return marketReceivedTimestamp;
	}
	public void setMarketReceivedTimestamp(String marketReceivedTimestamp) {
		this.marketReceivedTimestamp = marketReceivedTimestamp;
	}
	
	public List<String> getEnrollmentSystemCodes() {
		return enrollmentSystemCodes;
	}
	public void setEnrollmentSystemCodes(List<String> enrollmentSystemCodes) {
		this.enrollmentSystemCodes = enrollmentSystemCodes;
	}
	public String getOnlineEnrollmentCenterConfirmationId() {
		return onlineEnrollmentCenterConfirmationId;
	}
	public void setOnlineEnrollmentCenterConfirmationId(String onlineEnrollmentCenterConfirmationId) {
		this.onlineEnrollmentCenterConfirmationId = onlineEnrollmentCenterConfirmationId;
	}
	public ApplicationSignature getApplicationSignature() {
		return applicationSignature;
	}
	public void setApplicationSignature(ApplicationSignature applicationSignature) {
		this.applicationSignature = applicationSignature;
	}
	public String getDocumentControlNumber() {
		return documentControlNumber;
	}
	public void setDocumentControlNumber(String documentControlNumber) {
		this.documentControlNumber = documentControlNumber;
	}
	public String getScopeOfAppointmentLocationType() {
		return scopeOfAppointmentLocationType;
	}
	public void setScopeOfAppointmentLocationType(String scopeOfAppointmentLocationType) {
		this.scopeOfAppointmentLocationType = scopeOfAppointmentLocationType;
	}
	public FileInformation getFileInformation() {
		return fileInformation;
	}
	public void setFileInformation(FileInformation fileInformation) {
		this.fileInformation = fileInformation;
	}
	public String getCoverageTerminationDate() {
		return coverageTerminationDate;
	}
	public void setCoverageTerminationDate(String coverageTerminationDate) {
		this.coverageTerminationDate = coverageTerminationDate;
	}


}
