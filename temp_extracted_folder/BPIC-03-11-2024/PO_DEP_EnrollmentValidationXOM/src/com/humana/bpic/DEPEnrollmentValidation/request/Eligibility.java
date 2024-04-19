package com.humana.bpic.DEPEnrollmentValidation.request;

//This is part of 124AM rules development
public class Eligibility {
	private String medicarePartAIndicator="";
    private String medicarePartAEligibilityDate="";
    private String medicarePartBEligibilityDate="";
    private String memberEndDate="";
    private String memberStartDate="";
    private String temporaryDate="";
    private String specialReasonCode="";
    private String rfmMedicareElectionTypeCode="";
    private String rfmMemberMartialStatus="";
    private String cmsContractId="";
    private String cmsPBPId="";
    private boolean medicareEligible=false;
    
	public String getMedicarePartAIndicator() {
		return medicarePartAIndicator;
	}
	public void setMedicarePartAIndicator(String medicarePartAIndicator) {
		this.medicarePartAIndicator = medicarePartAIndicator;
	}
	public String getMedicarePartAEligibilityDate() {
		return medicarePartAEligibilityDate;
	}
	public void setMedicarePartAEligibilityDate(String medicarePartAEligibilityDate) {
		this.medicarePartAEligibilityDate = medicarePartAEligibilityDate;
	}
	public String getMedicarePartBEligibilityDate() {
		return medicarePartBEligibilityDate;
	}
	public void setMedicarePartBEligibilityDate(String medicarePartBEligibilityDate) {
		this.medicarePartBEligibilityDate = medicarePartBEligibilityDate;
	}
	public String getMemberEndDate() {
		return memberEndDate;
	}
	public void setMemberEndDate(String memberEndDate) {
		this.memberEndDate = memberEndDate;
	}
	public String getMemberStartDate() {
		return memberStartDate;
	}
	public void setMemberStartDate(String memberStartDate) {
		this.memberStartDate = memberStartDate;
	}
	public String getTemporaryDate() {
		return temporaryDate;
	}
	public void setTemporaryDate(String temporaryDate) {
		this.temporaryDate = temporaryDate;
	}
	public String getSpecialReasonCode() {
		return specialReasonCode;
	}
	public String getCmsContractId() {
		return cmsContractId;
	}
	public void setCmsContractId(String cmsContractId) {
		this.cmsContractId = cmsContractId;
	}
	public void setSpecialReasonCode(String specialReasonCode) {
		this.specialReasonCode = specialReasonCode;
	}
	public String getRfmMedicareElectionTypeCode() {
		return rfmMedicareElectionTypeCode;
	}
	public void setRfmMedicareElectionTypeCode(String rfmMedicareElectionTypeCode) {
		this.rfmMedicareElectionTypeCode = rfmMedicareElectionTypeCode;
	}
	public String getRfmMemberMartialStatus() {
		return rfmMemberMartialStatus;
	}
	public void setRfmMemberMartialStatus(String rfmMemberMartialStatus) {
		this.rfmMemberMartialStatus = rfmMemberMartialStatus;
	}
	public String getCmsPBPId() {
		return cmsPBPId;
	}
	public void setCmsPBPId(String cmsPBPId) {
		this.cmsPBPId = cmsPBPId;
	}
	public boolean isMedicareEligible() {
		return medicareEligible;
	}
	public void setMedicareEligible(boolean medicareEligible) {
		this.medicareEligible = medicareEligible;
	}
    
    

}
