package com.humana.bpic.DEPEnrollmentValidation.request;

import java.util.Objects;

public class OfficialIdentifiers {
	private String identifierCode="";
	private String identifierDefinition="";
	private String identifierValue="";
	private String identifierIssuingAuthority="";
	

	public String getIdentifierCode() {
		if(Objects.isNull(this.identifierCode)) {
			this.identifierCode="";
		}
		return this.identifierCode;
	}
	public void setIdentifierCode(String identifierCode) {
		this.identifierCode = identifierCode;
	}
	public String getIdentifierDefinition() {
		return identifierDefinition;
	}
	public void setIdentifierDefinition(String identifierDefinition) {
		this.identifierDefinition = identifierDefinition;
	}

	public String getIdentifierValue() {
		if(Objects.isNull(this.identifierValue)) {
			this.identifierValue = "";
		}
		return this.identifierValue;
	}
	public void setIdentifierValue(String identifierValue) {
		this.identifierValue = identifierValue;
	}
	public String getIdentifierIssuingAuthority() {
		return identifierIssuingAuthority;
	}
	public void setIdentifierIssuingAuthority(String identifierIssuingAuthority) {
		this.identifierIssuingAuthority = identifierIssuingAuthority;
	}

}
