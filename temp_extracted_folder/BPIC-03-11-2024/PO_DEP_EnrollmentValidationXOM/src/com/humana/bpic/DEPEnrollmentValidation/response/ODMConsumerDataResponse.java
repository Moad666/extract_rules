package com.humana.bpic.DEPEnrollmentValidation.response;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.humana.bpic.DEPEnrollmentValidation.request.AgentsAndBrokers;
import com.humana.bpic.DEPEnrollmentValidation.request.Consumers;
import com.humana.bpic.DEPEnrollmentValidation.request.EnrollmentApplicationSubmission;
import com.humana.bpic.DEPEnrollmentValidation.request.Message;
import com.humana.bpic.DEPEnrollmentValidation.request.PartnerAndMarketing;
import com.humana.bpic.DEPEnrollmentValidation.utility.DEPEnrollmentHelper;

public class ODMConsumerDataResponse {
	private String transactionTrackingId="";
	private Date transactionDateTimeStamp=new Date();
	private Consumers consumers;
	private EnrollmentApplicationSubmission enrollmentApplicationSubmission;
	private List<AgentsAndBrokers> agentsAndBrokers;
	private PartnerAndMarketing partnerAndMarketing;
	private List<Message> messageList;
	private boolean isValidOfficialIdentifierMBIUsableFlag = true;
	private boolean isValidDemographicDOBUsableFlag = true;
	private boolean isValidMcarePolicyProposedEffectiveDateUsableFlag = true;
	//This is part of 124AM rules development
    private boolean isRaceCodeFoundFlag=true;
    private boolean isEthnicityCodeFoundFlag=true;
    private boolean isAe03SU10Ind=true;
    private boolean isAe03SU32Ind=true;
    private boolean isIndividualMedicare=true;
    private boolean isShortFormType=true;
    private boolean isValidBeqResponseMedicarePARTAStartDateUsableFlag=true;
    private boolean isWs03su65error=true;
    private boolean isForcedtoPendFlag=true;
    private boolean is03su26Error=true;
    private boolean isAemobvAe03su32Indicator=true;
    private boolean isAemobvAe03su10Indicator=true;
    private boolean isRecordFoundMFlag=true;
	
	public boolean isRaceCodeFoundFlag() {
		return isRaceCodeFoundFlag;
	}

	public void setRaceCodeFoundFlag(boolean isRaceCodeFoundFlag) {
		this.isRaceCodeFoundFlag = isRaceCodeFoundFlag;
	}

	public boolean isEthnicityCodeFoundFlag() {
		return isEthnicityCodeFoundFlag;
	}

	public void setEthnicityCodeFoundFlag(boolean isEthnicityCodeFoundFlag) {
		this.isEthnicityCodeFoundFlag = isEthnicityCodeFoundFlag;
	}

	public boolean isAe03SU10Ind() {
		return isAe03SU10Ind;
	}

	public void setAe03SU10Ind(boolean isAe03SU10Ind) {
		this.isAe03SU10Ind = isAe03SU10Ind;
	}

	public boolean isAe03SU32Ind() {
		return isAe03SU32Ind;
	}

	public void setAe03SU32Ind(boolean isAe03SU32Ind) {
		this.isAe03SU32Ind = isAe03SU32Ind;
	}

	public boolean isIndividualMedicare() {
		return isIndividualMedicare;
	}

	public void setIndividualMedicare(boolean isIndividualMedicare) {
		this.isIndividualMedicare = isIndividualMedicare;
	}

	public boolean isShortFormType() {
		return isShortFormType;
	}

	public void setShortFormType(boolean isShortFormType) {
		this.isShortFormType = isShortFormType;
	}

	public boolean isValidBeqResponseMedicarePARTAStartDateUsableFlag() {
		return isValidBeqResponseMedicarePARTAStartDateUsableFlag;
	}

	public void setValidBeqResponseMedicarePARTAStartDateUsableFlag(
			boolean isValidBeqResponseMedicarePARTAStartDateUsableFlag) {
		this.isValidBeqResponseMedicarePARTAStartDateUsableFlag = isValidBeqResponseMedicarePARTAStartDateUsableFlag;
	}

	public boolean isWs03su65error() {
		return isWs03su65error;
	}

	public void setWs03su65error(boolean isWs03su65error) {
		this.isWs03su65error = isWs03su65error;
	}

	public boolean isForcedtoPendFlag() {
		return isForcedtoPendFlag;
	}

	public void setForcedtoPendFlag(boolean isForcedtoPendFlag) {
		this.isForcedtoPendFlag = isForcedtoPendFlag;
	}

	public boolean isIs03su26Error() {
		return is03su26Error;
	}

	public void setIs03su26Error(boolean is03su26Error) {
		this.is03su26Error = is03su26Error;
	}
	public boolean isAemobvAe03su32Indicator() {
		return isAemobvAe03su32Indicator;
	}

	public void setAemobvAe03su32Indicator(boolean isAemobvAe03su32Indicator) {
		this.isAemobvAe03su32Indicator = isAemobvAe03su32Indicator;
	}

	public boolean isAemobvAe03su10Indicator() {
		return isAemobvAe03su10Indicator;
	}

	public void setAemobvAe03su10Indicator(boolean isAemobvAe03su10Indicator) {
		this.isAemobvAe03su10Indicator = isAemobvAe03su10Indicator;
	}

	public boolean isRecordFoundMFlag() {
		return isRecordFoundMFlag;
	}

	public void setRecordFoundMFlag(boolean isRecordFoundMFlag) {
		this.isRecordFoundMFlag = isRecordFoundMFlag;
	}

	public String getTransactionTrackingId() {
		return transactionTrackingId;
	}

	public void setTransactionTrackingId(String transactionTrackingId) {
		this.transactionTrackingId = transactionTrackingId;
	}

	public Date getTransactionDateTimeStamp() {
		return transactionDateTimeStamp;
	}

	public void setTransactionDateTimeStamp(Date transactionDateTimeStamp) {
		this.transactionDateTimeStamp = DEPEnrollmentHelper.convertToUTCDate(transactionDateTimeStamp);
	}

	public Consumers getConsumers() {
		return consumers;
	}

	public void setConsumers(Consumers consumers) {
		this.consumers = consumers;
	}

	public EnrollmentApplicationSubmission getEnrollmentApplicationSubmission() {
		return enrollmentApplicationSubmission;
	}

	public void setEnrollmentApplicationSubmission(EnrollmentApplicationSubmission enrollmentApplicationSubmission) {
		this.enrollmentApplicationSubmission = enrollmentApplicationSubmission;
	}

	public List<AgentsAndBrokers> getAgentsAndBrokers() {
		if (agentsAndBrokers == null)
			agentsAndBrokers = new ArrayList<AgentsAndBrokers>();
		return agentsAndBrokers;
	}

	public void setAgentsAndBrokers(List<AgentsAndBrokers> agentsAndBrokers) {
		this.agentsAndBrokers = agentsAndBrokers;
	}

	public PartnerAndMarketing getPartnerAndMarketing() {
		return partnerAndMarketing;
	}

	public void setPartnerAndMarketing(PartnerAndMarketing partnerAndMarketing) {
		this.partnerAndMarketing = partnerAndMarketing;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	public boolean isValidOfficialIdentifierMBIUsableFlag() {
		return isValidOfficialIdentifierMBIUsableFlag;
	}

	public void setValidOfficialIdentifierMBIUsableFlag(boolean isValidOfficialIdentifierMBIUsableFlag) {
		this.isValidOfficialIdentifierMBIUsableFlag = isValidOfficialIdentifierMBIUsableFlag;
	}

	public boolean isValidDemographicDOBUsableFlag() {
		return isValidDemographicDOBUsableFlag;
	}

	public void setValidDemographicDOBUsableFlag(boolean isValidDemographicDOBUsableFlag) {
		this.isValidDemographicDOBUsableFlag = isValidDemographicDOBUsableFlag;
	}

	public boolean isValidMcarePolicyProposedEffectiveDateUsableFlag() {
		return isValidMcarePolicyProposedEffectiveDateUsableFlag;
	}

	public void setValidMcarePolicyProposedEffectiveDateUsableFlag(
			boolean isValidMcarePolicyProposedEffectiveDateUsableFlag) {
		this.isValidMcarePolicyProposedEffectiveDateUsableFlag = isValidMcarePolicyProposedEffectiveDateUsableFlag;
	}

}