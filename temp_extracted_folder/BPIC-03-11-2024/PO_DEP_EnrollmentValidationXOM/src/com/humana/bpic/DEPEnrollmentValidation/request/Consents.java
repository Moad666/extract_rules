package com.humana.bpic.DEPEnrollmentValidation.request;

import java.util.List;

public class Consents {
private ConsentDates consentDates;
private String consentDisclosureType="";
private String limitedDisclosureStatement="";
private List<String> limitedDisclosureProductType;
private ConsentSignature consentSignature;
private String consentSource="";
public ConsentDates getConsentDates() {
	return consentDates;
}
public void setConsentDates(ConsentDates consentDates) {
	this.consentDates = consentDates;
}
public String getConsentDisclosureType() {
	return consentDisclosureType;
}
public void setConsentDisclosureType(String consentDisclosureType) {
	this.consentDisclosureType = consentDisclosureType;
}
public String getLimitedDisclosureStatement() {
	return limitedDisclosureStatement;
}
public void setLimitedDisclosureStatement(String limitedDisclosureStatement) {
	this.limitedDisclosureStatement = limitedDisclosureStatement;
}
public List<String> getLimitedDisclosureProductType() {
	return limitedDisclosureProductType;
}
public void setLimitedDisclosureProductType(List<String> limitedDisclosureProductType) {
	this.limitedDisclosureProductType = limitedDisclosureProductType;
}
public ConsentSignature getConsentSignature() {
	return consentSignature;
}
public void setConsentSignature(ConsentSignature consentSignature) {
	this.consentSignature = consentSignature;
}
public String getConsentSource() {
	return consentSource;
}
public void setConsentSource(String consentSource) {
	this.consentSource = consentSource;
}

}
