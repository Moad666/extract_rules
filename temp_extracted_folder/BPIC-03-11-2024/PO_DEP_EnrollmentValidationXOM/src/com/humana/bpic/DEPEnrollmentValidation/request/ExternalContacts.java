package com.humana.bpic.DEPEnrollmentValidation.request;

import java.util.List;

public class ExternalContacts {
	private String contactPersonType="";
	private String contactRelationship="";
	private String prefix="";
	private String firstName="";
	private String middleName="";
	private String middleInitial="";
	private String lastName="";
	private String suffix="";
	private List<PhoneNumbers> phoneNumbers;
	private String emailAddress="";
	private ContactAddress contactAddress;
	public String getContactPersonType() {
		return contactPersonType;
	}
	public void setContactPersonType(String contactPersonType) {
		this.contactPersonType = contactPersonType;
	}
	public String getContactRelationship() {
		return contactRelationship;
	}
	public void setContactRelationship(String contactRelationship) {
		this.contactRelationship = contactRelationship;
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
	public List<PhoneNumbers> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<PhoneNumbers> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public ContactAddress getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(ContactAddress contactAddress) {
		this.contactAddress = contactAddress;
	}

}

	