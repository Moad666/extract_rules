package com.humana.bpic.DEPEnrollmentValidation.request;

public class Conditions {
	private Boolean isSmoker=false;
	private  boolean hasDisability;
	
	public Boolean getIsSmoker() {
		return isSmoker;
	}
	public void setIsSmoker(Boolean isSmoker) {
		this.isSmoker = isSmoker;
	}
	public boolean isHasDisability() {
		return hasDisability;
	}
	public void setHasDisability(boolean hasDisability) {
		this.hasDisability = hasDisability;
	}

}
