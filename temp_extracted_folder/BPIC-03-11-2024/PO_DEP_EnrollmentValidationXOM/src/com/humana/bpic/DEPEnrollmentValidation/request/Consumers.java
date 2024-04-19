package com.humana.bpic.DEPEnrollmentValidation.request;


import java.util.List;

public class Consumers {
	private String prefix="";
	private String firstName="";
	private String middleName="";
	private String middleInitial="";
	private String lastName="";
	private String suffix="";
	private String dateOfBirthDate="";
	private String sex="";
	private Biometrics biometrics ;
	private AdditionalDemographics additionalDemographics;
	private List<OfficialIdentifiers> officialIdentifiers;
	private List<InternalIdentifiers> internalIdentifiers;
	private ContactInformation contactInformation;
	private List<ExternalContacts> externalContacts;
	private OtherInsurances otherInsurances;
	private List<Plans> plans;
	private List<OptionalSupplementalBenefits> optionalSupplementalBenefits;
	private List<OtherCoverages> otherCoverages;
	private List<Providers> providers;
	private List<PaymentPreferences> paymentPreferences;
	private CommunicationPreferences communicationPreferences;
	private Conditions conditions;
	private List<ChronicConditions> chronicConditions;
	private LongTermCare longTermCare;
	//Added below attributes on 11/03/2023 for the DEP_Iterarion3.4
	private String deceasedDate="";
	private List<Designees> designees; 
	//Added below attribute on 01/30/2024 for the DEP_Iterarion4.4
	private int age;
	//This is a part of 124AM rules development
	private String formTypeCode="";
    private String govtSourceCode="";
    private String govtSalesSSN="";
    private String rfmGovtSalesSSN="";
    private List<String> aeiaGhiMemberRecordLayout;
    private String msupWaSSN="";
    private boolean isDiabetes=false;
    private boolean isOsteo=false;
    private boolean individualMedSup=false;
    private boolean groupMedSup=false;
    private List<String> rfmGroupId;
    private String stokRecordTypeHeader="";
    private String sexCode="";
    private String memberGenderCode="";
    private String extoutMemberStatus="";
    private String referenceIdentificationQualifier="";
    private String rfmCategoryKey="";
    private String employmentStatusCode="";
    private String individualRelationshipCode="";
    private String subscriberSSN="";
    private String subSaveSSN="";
    private String homeAddress="";
    private String oldCategoryId="";
    private int wsCount1=0;
    private int wsCount2=0;
    private Eligibility eligibility;
    private String rfmEmploymentStateCode="";
    private String govtSalesREPName="";
    
	public String getGovtSalesREPName() {
		return govtSalesREPName;
	}
	public void setGovtSalesREPName(String govtSalesREPName) {
		this.govtSalesREPName = govtSalesREPName;
	}
	public String getRfmEmploymentStateCode() {
		return rfmEmploymentStateCode;
	}
	public void setRfmEmploymentStateCode(String rfmEmploymentStateCode) {
		this.rfmEmploymentStateCode = rfmEmploymentStateCode;
	}
	public int getWsCount1() {
		return wsCount1;
	}
	public void setWsCount1(int wsCount1) {
		this.wsCount1 = wsCount1;
	}
	public int getWsCount2() {
		return wsCount2;
	}
	public void setWsCount2(int wsCount2) {
		this.wsCount2 = wsCount2;
	}
	public String getFormTypeCode() {
		return formTypeCode;
	}
	public void setFormTypeCode(String formTypeCode) {
		this.formTypeCode = formTypeCode;
	}
	public String getGovtSourceCode() {
		return govtSourceCode;
	}
	public void setGovtSourceCode(String govtSourceCode) {
		this.govtSourceCode = govtSourceCode;
	}
	public String getGovtSalesSSN() {
		return govtSalesSSN;
	}
	public void setGovtSalesSSN(String govtSalesSSN) {
		this.govtSalesSSN = govtSalesSSN;
	}
	public String getRfmGovtSalesSSN() {
		return rfmGovtSalesSSN;
	}
	public void setRfmGovtSalesSSN(String rfmGovtSalesSSN) {
		this.rfmGovtSalesSSN = rfmGovtSalesSSN;
	}
	public List<String> getAeiaGhiMemberRecordLayout() {
		return aeiaGhiMemberRecordLayout;
	}
	public void setAeiaGhiMemberRecordLayout(List<String> aeiaGhiMemberRecordLayout) {
		this.aeiaGhiMemberRecordLayout = aeiaGhiMemberRecordLayout;
	}
	public String getMsupWaSSN() {
		return msupWaSSN;
	}
	public void setMsupWaSSN(String msupWaSSN) {
		this.msupWaSSN = msupWaSSN;
	}
	public boolean isDiabetes() {
		return isDiabetes;
	}
	public void setDiabetes(boolean isDiabetes) {
		this.isDiabetes = isDiabetes;
	}
	public boolean isOsteo() {
		return isOsteo;
	}
	public void setOsteo(boolean isOsteo) {
		this.isOsteo = isOsteo;
	}
	public boolean isIndividualMedSup() {
		return individualMedSup;
	}
	public void setIndividualMedSup(boolean individualMedSup) {
		this.individualMedSup = individualMedSup;
	}
	public boolean isGroupMedSup() {
		return groupMedSup;
	}
	public void setGroupMedSup(boolean groupMedSup) {
		this.groupMedSup = groupMedSup;
	}
	public List<String> getRfmGroupId() {
		return rfmGroupId;
	}
	public void setRfmGroupId(List<String> rfmGroupId) {
		this.rfmGroupId = rfmGroupId;
	}
	public String getStokRecordTypeHeader() {
		return stokRecordTypeHeader;
	}
	public void setStokRecordTypeHeader(String stokRecordTypeHeader) {
		this.stokRecordTypeHeader = stokRecordTypeHeader;
	}
	public String getSexCode() {
		return sexCode;
	}
	public void setSexCode(String sexCode) {
		this.sexCode = sexCode;
	}
	public String getMemberGenderCode() {
		return memberGenderCode;
	}
	public void setMemberGenderCode(String memberGenderCode) {
		this.memberGenderCode = memberGenderCode;
	}
	public String getExtoutMemberStatus() {
		return extoutMemberStatus;
	}
	public void setExtoutMemberStatus(String extoutMemberStatus) {
		this.extoutMemberStatus = extoutMemberStatus;
	}
	public String getReferenceIdentificationQualifier() {
		return referenceIdentificationQualifier;
	}
	public void setReferenceIdentificationQualifier(String referenceIdentificationQualifier) {
		this.referenceIdentificationQualifier = referenceIdentificationQualifier;
	}
	public String getRfmCategoryKey() {
		return rfmCategoryKey;
	}
	public void setRfmCategoryKey(String rfmCategoryKey) {
		this.rfmCategoryKey = rfmCategoryKey;
	}
	public String getEmploymentStatusCode() {
		return employmentStatusCode;
	}
	public void setEmploymentStatusCode(String employmentStatusCode) {
		this.employmentStatusCode = employmentStatusCode;
	}
	public String getIndividualRelationshipCode() {
		return individualRelationshipCode;
	}
	public void setIndividualRelationshipCode(String individualRelationshipCode) {
		this.individualRelationshipCode = individualRelationshipCode;
	}
	public String getSubscriberSSN() {
		return subscriberSSN;
	}
	public void setSubscriberSSN(String subscriberSSN) {
		this.subscriberSSN = subscriberSSN;
	}
	public String getSubSaveSSN() {
		return subSaveSSN;
	}
	public void setSubSaveSSN(String subSaveSSN) {
		this.subSaveSSN = subSaveSSN;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getOldCategoryId() {
		return oldCategoryId;
	}
	public void setOldCategoryId(String oldCategoryId) {
		this.oldCategoryId = oldCategoryId;
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
	public String getDateOfBirthDate() {
		return dateOfBirthDate;
	}
	public void setDateOfBirthDate(String dateOfBirthDate) {
		this.dateOfBirthDate = dateOfBirthDate;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Biometrics getBiometrics() {
		return biometrics;
	}
	public void setBiometrics(Biometrics biometrics) {
		this.biometrics = biometrics;
	}
	public AdditionalDemographics getAdditionalDemographics() {
		return additionalDemographics;
	}
	public Eligibility getEligibility() {
		return eligibility;
	}
	public void setEligibility(Eligibility eligibility) {
		this.eligibility = eligibility;
	}
	public void setAdditionalDemographics(AdditionalDemographics additionalDemographics) {
		this.additionalDemographics = additionalDemographics;
	}
	public List<OfficialIdentifiers> getOfficialIdentifiers() {
		return officialIdentifiers;
	}
	public void setOfficialIdentifiers(List<OfficialIdentifiers> officialIdentifiers) {
		this.officialIdentifiers = officialIdentifiers;
	}
	public List<InternalIdentifiers> getInternalIdentifiers() {
		return internalIdentifiers;
	}
	public void setInternalIdentifiers(List<InternalIdentifiers> internalIdentifiers) {
		this.internalIdentifiers = internalIdentifiers;
	}
	public ContactInformation getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(ContactInformation contactInformation) {
		this.contactInformation = contactInformation;
	}
	public List<ExternalContacts> getExternalContacts() {
		return externalContacts;
	}
	public void setExternalContacts(List<ExternalContacts> externalContacts) {
		this.externalContacts = externalContacts;
	}
	public OtherInsurances getOtherInsurances() {
		return otherInsurances;
	}
	public void setOtherInsurances(OtherInsurances otherInsurances) {
		this.otherInsurances = otherInsurances;
	}
	public List<Plans> getPlans() {
		return plans;
	}
	public void setPlans(List<Plans> plans) {
		this.plans = plans;
	}
	public List<OptionalSupplementalBenefits> getOptionalSupplementalBenefits() {
		return optionalSupplementalBenefits;
	}
	public void setOptionalSupplementalBenefits(List<OptionalSupplementalBenefits> optionalSupplementalBenefits) {
		this.optionalSupplementalBenefits = optionalSupplementalBenefits;
	}
	public List<OtherCoverages> getOtherCoverages() {
		return otherCoverages;
	}
	public void setOtherCoverages(List<OtherCoverages> otherCoverages) {
		this.otherCoverages = otherCoverages;
	}
	public List<Providers> getProviders() {
		return providers;
	}
	public void setProviders(List<Providers> providers) {
		this.providers = providers;
	}
	public List<PaymentPreferences> getPaymentPreferences() {
		return paymentPreferences;
	}
	public void setPaymentPreferences(List<PaymentPreferences> paymentPreferences) {
		this.paymentPreferences = paymentPreferences;
	}
	public CommunicationPreferences getCommunicationPreferences() {
		return communicationPreferences;
	}
	public void setCommunicationPreferences(CommunicationPreferences communicationPreferences) {
		this.communicationPreferences = communicationPreferences;
	}
	public Conditions getConditions() {
		return conditions;
	}
	public void setConditions(Conditions conditions) {
		this.conditions = conditions;
	}
	public List<ChronicConditions> getChronicConditions() {
		return chronicConditions;
	}
	public void setChronicConditions(List<ChronicConditions> chronicConditions) {
		this.chronicConditions = chronicConditions;
	}
	public LongTermCare getLongTermCare() {
		return longTermCare;
	}
	public void setLongTermCare(LongTermCare longTermCare) {
		this.longTermCare = longTermCare;
	}
	public String getDeceasedDate() {
		return deceasedDate;
	}
	public void setDeceasedDate(String deceasedDate) {
		this.deceasedDate = deceasedDate;
	}
	public List<Designees> getDesignees() {
		return designees;
	}
	public void setDesignees(List<Designees> designees) {
		this.designees = designees;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
	