package com.humana.bpic.DEPEnrollmentValidation.request;

//This is part of 124AM rules development
public class Ae409 {
	private boolean lk409OsbForm=false;
    private boolean lk409GroupMcare=false;
    private String lk409FormTypeCode="";
    private String shortForm="";
    
	public boolean isLk409OsbForm() {
		return lk409OsbForm;
	}
	public void setLk409OsbForm(boolean lk409OsbForm) {
		this.lk409OsbForm = lk409OsbForm;
	}
	public boolean isLk409GroupMcare() {
		return lk409GroupMcare;
	}
	public void setLk409GroupMcare(boolean lk409GroupMcare) {
		this.lk409GroupMcare = lk409GroupMcare;
	}
	public String getLk409FormTypeCode() {
		return lk409FormTypeCode;
	}
	public void setLk409FormTypeCode(String lk409FormTypeCode) {
		this.lk409FormTypeCode = lk409FormTypeCode;
	}
	public String getShortForm() {
		return shortForm;
	}
	public void setShortForm(String shortForm) {
		this.shortForm = shortForm;
	}


}
