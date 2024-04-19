package com.humana.bpic.DEPEnrollmentValidation.request;

public class Plans {
	private String contractNumber="";
	private String planBenefitPackageNumber="";
	private String segmentNumber="";
	private String groupId="";
	private String benefitSequenceNumber="";
	private String lineOfCoverage="";
	private String lineOfBusiness="";
	private double planCostPremiumAmount;
	private String planName="";
	public String getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	public String getPlanBenefitPackageNumber() {
		return planBenefitPackageNumber;
	}
	public void setPlanBenefitPackageNumber(String planBenefitPackageNumber) {
		this.planBenefitPackageNumber = planBenefitPackageNumber;
	}
	public String getSegmentNumber() {
		return segmentNumber;
	}
	public void setSegmentNumber(String segmentNumber) {
		this.segmentNumber = segmentNumber;
	}
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getBenefitSequenceNumber() {
		return benefitSequenceNumber;
	}
	public void setBenefitSequenceNumber(String benefitSequenceNumber) {
		this.benefitSequenceNumber = benefitSequenceNumber;
	}
	public String getLineOfCoverage() {
		return lineOfCoverage;
	}
	public void setLineOfCoverage(String lineOfCoverage) {
		this.lineOfCoverage = lineOfCoverage;
	}

	public String getLineOfBusiness() {
		return lineOfBusiness;
	}
	public void setLineOfBusiness(String lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}
	public double getPlanCostPremiumAmount() {
		return planCostPremiumAmount;
	}
	public void setPlanCostPremiumAmount(double planCostPremiumAmount) {
		this.planCostPremiumAmount = planCostPremiumAmount;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}

}
