package com.humana.bpic.DEPEnrollmentValidation.request;


public class AdditionalDemographics {
	private String maritalStatus="";
	private String veteranStatus="";
	//This is part of 124AM rules development
	private Ethnicity ethnicity;
	private Race race;
	//Added below attribute on 01/30/2024 for the DEP_Iterarion4.4
	private Boolean isHomeless=false;
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getVeteranStatus() {
		return veteranStatus;
	}
	public void setVeteranStatus(String veteranStatus) {
		this.veteranStatus = veteranStatus;
	}
	public Ethnicity getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(Ethnicity ethnicity) {
		this.ethnicity = ethnicity;
	}
	public Race getRace() {
		return race;
	}
	public void setRace(Race race) {
		this.race = race;
	}
	public Boolean getIsHomeless() {
		return isHomeless;
	}
	public void setIsHomeless(Boolean isHomeless) {
		this.isHomeless = isHomeless;
	}	

}
