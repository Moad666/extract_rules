package com.humana.bpic.DEPEnrollmentValidation.request;

public class LongTermCare {
	private Boolean isInLongTermCare=false;
	private String organizationId="";
	private String longTermCareFacilityName="";
	private String longTermCareFacilityPhoneNumber="";
	private LongTermCareFacilityAddress longTermCareFacilityAddress;
	private String longTermCareLocationType="";
	//Added below attribute on 02/01/2024 for the DEP_Iterarion4.4
	private InLongTermCarePeriod inLongTermCarePeriod;
		
	public Boolean getIsInLongTermCare() {
		return isInLongTermCare;
	}
	public void setIsInLongTermCare(Boolean isInLongTermCare) {
		this.isInLongTermCare = isInLongTermCare;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getLongTermCareFacilityName() {
		return longTermCareFacilityName;
	}
	public void setLongTermCareFacilityName(String longTermCareFacilityName) {
		this.longTermCareFacilityName = longTermCareFacilityName;
	}
	public String getLongTermCareFacilityPhoneNumber() {
		return longTermCareFacilityPhoneNumber;
	}
	public void setLongTermCareFacilityPhoneNumber(String longTermCareFacilityPhoneNumber) {
		this.longTermCareFacilityPhoneNumber = longTermCareFacilityPhoneNumber;
	}
	public LongTermCareFacilityAddress getLongTermCareFacilityAddress() {
		return longTermCareFacilityAddress;
	}
	public void setLongTermCareFacilityAddress(LongTermCareFacilityAddress longTermCareFacilityAddress) {
		this.longTermCareFacilityAddress = longTermCareFacilityAddress;
	}
	public String getLongTermCareLocationType() {
		return longTermCareLocationType;
	}
	public void setLongTermCareLocationType(String longTermCareLocationType) {
		this.longTermCareLocationType = longTermCareLocationType;
	}
	public InLongTermCarePeriod getInLongTermCarePeriod() {
		return inLongTermCarePeriod;
	}
	public void setInLongTermCarePeriod(InLongTermCarePeriod inLongTermCarePeriod) {
		this.inLongTermCarePeriod = inLongTermCarePeriod;
	}

}
