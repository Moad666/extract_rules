package com.humana.bpic.DEPEnrollmentValidation.request;

import java.util.List;

public class Designees {
	private String designeeRole="";
	private String designeeType="";
	private String organizationName="";
	private String relationshipType="";
	private String prefix="";
	private String firstName="";
	private String middleName="";
	private String middleInitial="";
	private String lastName="";
	private String suffix="";
	private String dateOfBirthDate="";
	private List<PhoneNumbers> phoneNumbers;
	private List<EmailAddresses> emailAddresses;
	private List<DesigneesPostalAddresses> postalAddresses;
	private String powerOfAttorneyType="";
	private List<Consents> consents;
	//This is a part of 124AM rules development
	private String addressInformation="";
	private String am555Country="";
	private String fipsResd="";
	
	public String getAddressInformation() {
		return addressInformation;
	}
	public void setAddressInformation(String addressInformation) {
		this.addressInformation = addressInformation;
	}
	public String getAm555Country() {
		return am555Country;
	}
	public void setAm555Country(String am555Country) {
		this.am555Country = am555Country;
	}
	public String getFipsResd() {
		return fipsResd;
	}
	public void setFipsResd(String fipsResd) {
		this.fipsResd = fipsResd;
	}
	public String getDesigneeRole() {
		return designeeRole;
	}
	public void setDesigneeRole(String designeeRole) {
		this.designeeRole = designeeRole;
	}
	public String getDesigneeType() {
		return designeeType;
	}
	public void setDesigneeType(String designeeType) {
		this.designeeType = designeeType;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getRelationshipType() {
		return relationshipType;
	}
	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
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
	public List<PhoneNumbers> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<PhoneNumbers> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public List<EmailAddresses> getEmailAddresses() {
		return emailAddresses;
	}
	public void setEmailAddresses(List<EmailAddresses> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}
	public List<DesigneesPostalAddresses> getPostalAddresses() {
		return postalAddresses;
	}
	public void setPostalAddresses(List<DesigneesPostalAddresses> postalAddresses) {
		this.postalAddresses = postalAddresses;
	}
	public String getPowerOfAttorneyType() {
		return powerOfAttorneyType;
	}
	public void setPowerOfAttorneyType(String powerOfAttorneyType) {
		this.powerOfAttorneyType = powerOfAttorneyType;
	}
	public List<Consents> getConsents() {
		return consents;
	}
	public void setConsents(List<Consents> consents) {
		this.consents = consents;
	}
	
}