package com.humana.bpic.DEPEnrollmentValidation.request;

import java.util.List;

//This is part of 124AM rules development
public class SystemsFiller {
	private String systemsFiller="";
    private String contactRelationship="";
    private List<String> systemsFillerList;
	public String getSystemsFiller() {
		return systemsFiller;
	}
	public void setSystemsFiller(String systemsFiller) {
		this.systemsFiller = systemsFiller;
	}
	public String getContactRelationship() {
		return contactRelationship;
	}
	public void setContactRelationship(String contactRelationship) {
		this.contactRelationship = contactRelationship;
	}
	public List<String> getSystemsFillerList() {
		return systemsFillerList;
	}
	public void setSystemsFillerList(List<String> systemsFillerList) {
		this.systemsFillerList = systemsFillerList;
	}
}
