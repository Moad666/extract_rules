package com.humana.bpic.DEPEnrollmentValidation.request;

public class PhoneNumbers {
	private String phoneNumberType="";
	private String phoneNumber="";
	private String phoneNumberExtension="";
	public String getPhoneNumberType() {
		return phoneNumberType;
	}
	public void setPhoneNumberType(String phoneNumberType) {
		this.phoneNumberType = phoneNumberType;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumberExtension() {
		return phoneNumberExtension;
	}
	public void setPhoneNumberExtension(String phoneNumberExtension) {
		this.phoneNumberExtension = phoneNumberExtension;
	}

}
