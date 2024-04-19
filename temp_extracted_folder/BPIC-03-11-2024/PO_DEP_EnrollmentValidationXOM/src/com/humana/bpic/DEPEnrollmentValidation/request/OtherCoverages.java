package com.humana.bpic.DEPEnrollmentValidation.request;

import java.util.List;

public class OtherCoverages {
	private String lineOfCoverage="";
	private Boolean isPrescriptionCoveredAsPartOfMedicalCoverage = false;
	private String carrierName="";
	private String carrierPhoneNumber="";
	private String coverageGroupId="";
	private String coveragePolicyNumber="";
	private CarrierAddress carrierAddress;
	//Added below attributes on 01/31/2024 for the DEP_Iterarion4.4
	private String carrierId="";
	private String carrierPayerSequenceType="";
	private CoveragePeriod coveragePeriod;
	private List<String> benefitCodes;
	//This is a part of 124AM rules development
	private String snpTypeCode="";
	private String benefitLine="";
	private String rfmBenefitLine="";
	private String medicareElectionTypeCode="";
	private String marketReceiptDate="";
	private String batchReceiptDate="";
	private String memberBenefitTerm="";
	private String memberBenefitDate="";
	private String outputCoverageTermReasonCode="";
	private Boolean groupMedicalSupplements=false;
	private int ciCoverageAgreementId=0;
	private String adminGroupXref="";
	private String administratorNumber="";
	private String rfmCoverageTermDate="";
	private String healthPlanCoverageDescription="";
	private String retirementDate="";
	private String benefitEndDate="";
	private String benefitStatusCode="";
	private String maintenanceReasonCode="";
	private String benefitEndReasonCode="";
	private String transactionType="";
	private List<String> rfmBenefitId;
	private List<String> rfmCiCategoryKey;
	private StandardDailyLayout standardDailyLayout;
	private String electionTypeCode="";
	private String formType="";
	private String benefitDescription="";
		
	public String getBenefitDescription() {
		return benefitDescription;
	}
	public void setBenefitDescription(String benefitDescription) {
		this.benefitDescription = benefitDescription;
	}
	public int getCiCoverageAgreementId() {
		return ciCoverageAgreementId;
	}
	public void setCiCoverageAgreementId(int ciCoverageAgreementId) {
		this.ciCoverageAgreementId = ciCoverageAgreementId;
	}
	public String getElectionTypeCode() {
		return electionTypeCode;
	}
	public void setElectionTypeCode(String electionTypeCode) {
		this.electionTypeCode = electionTypeCode;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public String getSnpTypeCode() {
		return snpTypeCode;
	}
	public void setSnpTypeCode(String snpTypeCode) {
		this.snpTypeCode = snpTypeCode;
	}
	public String getBenefitLine() {
		return benefitLine;
	}
	public void setBenefitLine(String benefitLine) {
		this.benefitLine = benefitLine;
	}
	public String getRfmBenefitLine() {
		return rfmBenefitLine;
	}
	public void setRfmBenefitLine(String rfmBenefitLine) {
		this.rfmBenefitLine = rfmBenefitLine;
	}
	public String getMedicareElectionTypeCode() {
		return medicareElectionTypeCode;
	}
	public void setMedicareElectionTypeCode(String medicareElectionTypeCode) {
		this.medicareElectionTypeCode = medicareElectionTypeCode;
	}
	public String getMarketReceiptDate() {
		return marketReceiptDate;
	}
	public void setMarketReceiptDate(String marketReceiptDate) {
		this.marketReceiptDate = marketReceiptDate;
	}
	public String getBatchReceiptDate() {
		return batchReceiptDate;
	}
	public void setBatchReceiptDate(String batchReceiptDate) {
		this.batchReceiptDate = batchReceiptDate;
	}
	public String getMemberBenefitTerm() {
		return memberBenefitTerm;
	}
	public void setMemberBenefitTerm(String memberBenefitTerm) {
		this.memberBenefitTerm = memberBenefitTerm;
	}
	public String getMemberBenefitDate() {
		return memberBenefitDate;
	}
	public void setMemberBenefitDate(String memberBenefitDate) {
		this.memberBenefitDate = memberBenefitDate;
	}
	public String getOutputCoverageTermReasonCode() {
		return outputCoverageTermReasonCode;
	}
	public void setOutputCoverageTermReasonCode(String outputCoverageTermReasonCode) {
		this.outputCoverageTermReasonCode = outputCoverageTermReasonCode;
	}
	public Boolean getGroupMedicalSupplements() {
		return groupMedicalSupplements;
	}
	public void setGroupMedicalSupplements(Boolean groupMedicalSupplements) {
		this.groupMedicalSupplements = groupMedicalSupplements;
	}
	public String getAdminGroupXref() {
		return adminGroupXref;
	}
	public void setAdminGroupXref(String adminGroupXref) {
		this.adminGroupXref = adminGroupXref;
	}
	public String getAdministratorNumber() {
		return administratorNumber;
	}
	public void setAdministratorNumber(String administratorNumber) {
		this.administratorNumber = administratorNumber;
	}
	public String getRfmCoverageTermDate() {
		return rfmCoverageTermDate;
	}
	public void setRfmCoverageTermDate(String rfmCoverageTermDate) {
		this.rfmCoverageTermDate = rfmCoverageTermDate;
	}
	public String getHealthPlanCoverageDescription() {
		return healthPlanCoverageDescription;
	}
	public void setHealthPlanCoverageDescription(String healthPlanCoverageDescription) {
		this.healthPlanCoverageDescription = healthPlanCoverageDescription;
	}
	public String getRetirementDate() {
		return retirementDate;
	}
	public void setRetirementDate(String retirementDate) {
		this.retirementDate = retirementDate;
	}
	public String getBenefitEndDate() {
		return benefitEndDate;
	}
	public void setBenefitEndDate(String benefitEndDate) {
		this.benefitEndDate = benefitEndDate;
	}
	public String getBenefitStatusCode() {
		return benefitStatusCode;
	}
	public void setBenefitStatusCode(String benefitStatusCode) {
		this.benefitStatusCode = benefitStatusCode;
	}
	public String getMaintenanceReasonCode() {
		return maintenanceReasonCode;
	}
	public void setMaintenanceReasonCode(String maintenanceReasonCode) {
		this.maintenanceReasonCode = maintenanceReasonCode;
	}
	public String getBenefitEndReasonCode() {
		return benefitEndReasonCode;
	}
	public void setBenefitEndReasonCode(String benefitEndReasonCode) {
		this.benefitEndReasonCode = benefitEndReasonCode;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public List<String> getRfmBenefitId() {
		return rfmBenefitId;
	}
	public void setRfmBenefitId(List<String> rfmBenefitId) {
		this.rfmBenefitId = rfmBenefitId;
	}
	public List<String> getRfmCiCategoryKey() {
		return rfmCiCategoryKey;
	}
	public void setRfmCiCategoryKey(List<String> rfmCiCategoryKey) {
		this.rfmCiCategoryKey = rfmCiCategoryKey;
	}
	public StandardDailyLayout getStandardDailyLayout() {
		return standardDailyLayout;
	}
	public void setStandardDailyLayout(StandardDailyLayout standardDailyLayout) {
		this.standardDailyLayout = standardDailyLayout;
	}
	public String getLineOfCoverage() {
		return lineOfCoverage;
	}
	public void setLineOfCoverage(String lineOfCoverage) {
		this.lineOfCoverage = lineOfCoverage;
	}
	public Boolean getIsPrescriptionCoveredAsPartOfMedicalCoverage() {
		return isPrescriptionCoveredAsPartOfMedicalCoverage;
	}
	public void setIsPrescriptionCoveredAsPartOfMedicalCoverage(Boolean isPrescriptionCoveredAsPartOfMedicalCoverage) {
		this.isPrescriptionCoveredAsPartOfMedicalCoverage = isPrescriptionCoveredAsPartOfMedicalCoverage;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public String getCarrierPhoneNumber() {
		return carrierPhoneNumber;
	}
	public void setCarrierPhoneNumber(String carrierPhoneNumber) {
		this.carrierPhoneNumber = carrierPhoneNumber;
	}
	public String getCoverageGroupId() {
		return coverageGroupId;
	}
	public void setCoverageGroupId(String coverageGroupId) {
		this.coverageGroupId = coverageGroupId;
	}
	public String getCoveragePolicyNumber() {
		return coveragePolicyNumber;
	}
	public void setCoveragePolicyNumber(String coveragePolicyNumber) {
		this.coveragePolicyNumber = coveragePolicyNumber;
	}
	public CarrierAddress getCarrierAddress() {
		return carrierAddress;
	}
	public void setCarrierAddress(CarrierAddress carrierAddress) {
		this.carrierAddress = carrierAddress;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getCarrierPayerSequenceType() {
		return carrierPayerSequenceType;
	}
	public void setCarrierPayerSequenceType(String carrierPayerSequenceType) {
		this.carrierPayerSequenceType = carrierPayerSequenceType;
	}
	public CoveragePeriod getCoveragePeriod() {
		return coveragePeriod;
	}
	public void setCoveragePeriod(CoveragePeriod coveragePeriod) {
		this.coveragePeriod = coveragePeriod;
	}
	public List<String> getBenefitCodes() {
		return benefitCodes;
	}
	public void setBenefitCodes(List<String> benefitCodes) {
		this.benefitCodes = benefitCodes;
	}
	
}
