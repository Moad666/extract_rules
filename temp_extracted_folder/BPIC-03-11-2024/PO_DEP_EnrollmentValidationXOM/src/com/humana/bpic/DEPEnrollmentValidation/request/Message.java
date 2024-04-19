package com.humana.bpic.DEPEnrollmentValidation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Message {
	
	private String ruleSetName="";
	private String type = "";
	private String issueCode= "";
	private String issueDescription="";
	@JsonInclude(Include.NON_EMPTY)
	private String actionCode= "";
	@JsonInclude(Include.NON_EMPTY)
	private String actionDescription="";
	private String fromValue="";
	@JsonInclude(Include.NON_EMPTY)
	private String toValue="";
	public String getRuleSetName() {
		return ruleSetName;
	}
	public void setRuleSetName(String ruleSetName) {
		this.ruleSetName = ruleSetName;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIssueCode() {
		return issueCode;
	}
	public void setIssueCode(String issueCode) {
		this.issueCode = issueCode;
	}
	public String getIssueDescription() {
		return issueDescription;
	}
	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}
	public String getActionCode() {
		return actionCode;
	}
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
	public String getActionDescription() {
		return actionDescription;
	}
	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}
	public String getFromValue() {
		return fromValue;
	}
	public void setFromValue(String fromValue) {
		this.fromValue = fromValue;
	}
	public String getToValue() {
		return toValue;
	}
	public void setToValue(String toValue) {
		this.toValue = toValue;
	}
	
}
