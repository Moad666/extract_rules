package com.humana.bpic.DEPEnrollmentValidation.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import com.humana.bpic.DEPEnrollmentValidation.request.Message;
import com.humana.bpic.DEPEnrollmentValidation.response.ODMConsumerDataResponse;

import ilog.rules.bom.annotations.NotBusiness;

public class DEPEnrollmentHelper {
	
	private final static String CONVERTEDTOUTC_METHOD_TIMEZONE_UTC = "UTC";
	private final static String CONVERTEDTOUTC_METHOD_DATE_FORMAT = "yyyy-MM-dd";
	@NotBusiness
	public static Date convertToUTCDate(Date sourceDate) {
		DateFormat dateFormat;
		Date utcDate = null;
		
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CONVERTEDTOUTC_METHOD_DATE_FORMAT);
			simpleDateFormat.setTimeZone(TimeZone.getTimeZone(CONVERTEDTOUTC_METHOD_TIMEZONE_UTC));
			String utcTime = simpleDateFormat.format(sourceDate);
			dateFormat = new SimpleDateFormat(CONVERTEDTOUTC_METHOD_DATE_FORMAT);
			utcDate = dateFormat.parse(utcTime);
			
		} catch (Exception ex) {
			
		}

		return utcDate;
	}
	/**
	 * addMBIErrors
	 * 
	 * @param rulesetName
	 * @param issueCode
	 * @param actionCode
	 * @param fromValue
	 * @param toValue
	 */
	public static void addMBIErrors(String rulesetName, String issueCode, String actionCode,String fromValue,String toValue,
			ODMConsumerDataResponse applicationSubmissionsResponse) {
		Message error = null;
		if (null != issueCode && issueCode.trim().length() > 0) {

			error = new Message();
			error.setRuleSetName(rulesetName);
			error.setIssueCode(issueCode);
			error.setActionCode(actionCode);
			error.setFromValue(fromValue);
			error.setToValue(toValue);

		}

		if (null != error) {
			if (applicationSubmissionsResponse.getMessageList() == null) {

				applicationSubmissionsResponse.setMessageList(new ArrayList<Message>());
			}

			applicationSubmissionsResponse.getMessageList().add(error);

			if (applicationSubmissionsResponse.getMessageList().size() > 0
					&& (issueCode != null && actionCode.isEmpty())) {
				applicationSubmissionsResponse.setValidOfficialIdentifierMBIUsableFlag(false);
			}
		}
	}

	/**
	 * addDOBErrors
	 * 
	 * @param rulesetName
	 * @param issueCode
	 * @param actionCode
	 * @param fromValue
	 * @param toValue
	 * @return
	 */
	public static void addDOBErrors(

			String rulesetName, String issueCode, String actionCode, String fromValue,String toValue,
			ODMConsumerDataResponse applicationSubmissionsResponse) {
		Message error = null;
		if (null != issueCode && issueCode.trim().length() > 0) {

			error = new Message();
			error.setRuleSetName(rulesetName);
			error.setIssueCode(issueCode);
			error.setActionCode(actionCode);
			error.setFromValue(fromValue);
			error.setToValue(toValue);

		}

		if (null != error) {
			if (applicationSubmissionsResponse.getMessageList() == null) {

				applicationSubmissionsResponse.setMessageList(new ArrayList<Message>());
			}

			applicationSubmissionsResponse.getMessageList().add(error);

			if (applicationSubmissionsResponse.getMessageList().size() > 0
					&& (issueCode != null && actionCode.isEmpty())) {
				applicationSubmissionsResponse.setValidDemographicDOBUsableFlag(false);
			}
		}
	}

	/**
	 * addProposedEffectiveDateErrors
	 * 
	 * @param rulesetName
	 * @param issueCode
	 * @param actionCode
	 * @param fromValue
	 * @param toValue
	 */
	public static void addProposedEffectiveDateErrors(String rulesetName, String issueCode, String actionCode, String fromValue, String toValue,
			ODMConsumerDataResponse applicationSubmissionsResponse) {
		Message error = null;
		if (null != issueCode && issueCode.trim().length() > 0) {

			error = new Message();
			error.setRuleSetName(rulesetName);
			error.setIssueCode(issueCode);
			error.setActionCode(actionCode);
			error.setFromValue(fromValue);
			error.setToValue(toValue);

		}

		if (null != error) {
			if (applicationSubmissionsResponse.getMessageList() == null) {

				applicationSubmissionsResponse.setMessageList(new ArrayList<Message>());
			}

			applicationSubmissionsResponse.getMessageList().add(error);

			if (applicationSubmissionsResponse.getMessageList().size() > 0
					&& (issueCode != null &&  actionCode.isEmpty())) {
				applicationSubmissionsResponse.setValidMcarePolicyProposedEffectiveDateUsableFlag(false);
			}
		}
	}
}


