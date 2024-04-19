package com.humana.bpic.DEPEnrollmentValidation.request;

import java.util.List;

public class Providers {
	private Boolean isEstablishedPatientForProvider=false;
	private String providerId="";
	private String providerDisplayName="";
	private String providerRelationType="";
	private List<String> associatedChronicConditionType;
	private ProviderAddress providerAddress;
	//Added below attributes on 01/31/2024 for the DEP_Iterarion4.4
	private String prefix="";
	private String firstName="";
	private String middleName="";
	private String middleInitial="";
	private String lastName="";
	private String suffix="";
	private String nationalProviderIdentifier="";
	//This is a part of 124AM rules development
	private String providerValidationStatusCode="";
    private String providerValidationDate="";
    private String rfmScanDate="";
	
	public String getProviderValidationStatusCode() {
		return providerValidationStatusCode;
	}
	public void setProviderValidationStatusCode(String providerValidationStatusCode) {
		this.providerValidationStatusCode = providerValidationStatusCode;
	}
	public String getProviderValidationDate() {
		return providerValidationDate;
	}
	public void setProviderValidationDate(String providerValidationDate) {
		this.providerValidationDate = providerValidationDate;
	}
	public String getRfmScanDate() {
		return rfmScanDate;
	}
	public void setRfmScanDate(String rfmScanDate) {
		this.rfmScanDate = rfmScanDate;
	}
	public Boolean getIsEstablishedPatientForProvider() {
		return isEstablishedPatientForProvider;
	}
	public void setIsEstablishedPatientForProvider(Boolean isEstablishedPatientForProvider) {
		this.isEstablishedPatientForProvider = isEstablishedPatientForProvider;
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getProviderDisplayName() {
		return providerDisplayName;
	}
	public void setProviderDisplayName(String providerDisplayName) {
		this.providerDisplayName = providerDisplayName;
	}
	public String getProviderRelationType() {
		return providerRelationType;
	}
	public void setProviderRelationType(String providerRelationType) {
		this.providerRelationType = providerRelationType;
	}
	
	public List<String> getAssociatedChronicConditionType() {
		return associatedChronicConditionType;
	}
	public void setAssociatedChronicConditionType(List<String> associatedChronicConditionType) {
		this.associatedChronicConditionType = associatedChronicConditionType;
	}
	public ProviderAddress getProviderAddress() {
		return providerAddress;
	}
	public void setProviderAddress(ProviderAddress providerAddress) {
		this.providerAddress = providerAddress;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getNationalProviderIdentifier() {
		return nationalProviderIdentifier;
	}
	public void setNationalProviderIdentifier(String nationalProviderIdentifier) {
		this.nationalProviderIdentifier = nationalProviderIdentifier;
	}	
	
}
