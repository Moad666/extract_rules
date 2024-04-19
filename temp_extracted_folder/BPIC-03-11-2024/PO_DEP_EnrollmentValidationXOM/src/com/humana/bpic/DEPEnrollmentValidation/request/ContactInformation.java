package com.humana.bpic.DEPEnrollmentValidation.request;


import java.util.List;



public class ContactInformation {
	private List<EmailAddresses> emailAddresses;
	private List<PhoneNumbers> phoneNumbers;
	private Boolean isResidenceAddressSameAsMailing=false;
	private List<PostalAddresses> postalAddresses;
	public List<EmailAddresses> getEmailAddresses() {
		return emailAddresses;
	}
	public void setEmailAddresses(List<EmailAddresses> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}
	public List<PhoneNumbers> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<PhoneNumbers> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Boolean getIsResidenceAddressSameAsMailing() {
		return isResidenceAddressSameAsMailing;
	}
	public void setIsResidenceAddressSameAsMailing(Boolean isResidenceAddressSameAsMailing) {
		this.isResidenceAddressSameAsMailing = isResidenceAddressSameAsMailing;
	}
	public List<PostalAddresses> getPostalAddresses() {
		return postalAddresses;
	}
	public void setPostalAddresses(List<PostalAddresses> postalAddresses) {
		this.postalAddresses = postalAddresses;
	}
	
}