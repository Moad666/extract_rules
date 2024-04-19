package com.humana.bpic.DEPEnrollmentValidation.request;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ODMConsumerDataRequest {
	private String transactionTrackingId="";
	private Consumers consumers;
	private EnrollmentApplicationSubmission enrollmentApplicationSubmission;
	private List<AgentsAndBrokers> agentsAndBrokers;
	private PartnerAndMarketing partnerAndMarketing;
	//This is part of 124AM rules development
    private ErrorHandling errorHandling;
	
	public ErrorHandling getErrorHandling() {
		return errorHandling;
	}
	public void setErrorHandling(ErrorHandling errorHandling) {
		this.errorHandling = errorHandling;
	}
	public String getTransactionTrackingId() {
		return transactionTrackingId;
	}
	public void setTransactionTrackingId(String transactionTrackingId) {
		this.transactionTrackingId = transactionTrackingId;
	}
	public Consumers getConsumers() {
        if (Objects.isNull(this.consumers)) {
            this.consumers = new Consumers();
        }
        return this.consumers;
    }
	public void setConsumers(Consumers consumers) {
		this.consumers = consumers;
	}
	public EnrollmentApplicationSubmission getEnrollmentApplicationSubmission() {
		if(Objects.isNull(this.enrollmentApplicationSubmission)) {
			this.enrollmentApplicationSubmission=new EnrollmentApplicationSubmission();
		}
		return this.enrollmentApplicationSubmission;
	}
	public void setEnrollmentApplicationSubmission(EnrollmentApplicationSubmission enrollmentApplicationSubmission) {
		this.enrollmentApplicationSubmission = enrollmentApplicationSubmission;
	}
	
	public List<AgentsAndBrokers> getAgentsAndBrokers() {
		if(Objects.isNull(this.agentsAndBrokers)){
			this.agentsAndBrokers=new ArrayList<AgentsAndBrokers>();
		}
		return this.agentsAndBrokers;
	}
	public void setAgentsAndBrokers(List<AgentsAndBrokers> agentsAndBrokers) {
		this.agentsAndBrokers = agentsAndBrokers;
	}
	public PartnerAndMarketing getPartnerAndMarketing() {
		if(Objects.isNull(this.partnerAndMarketing)) {
			this.partnerAndMarketing=new PartnerAndMarketing();	
		}
			return this.partnerAndMarketing;
	}
	public void setPartnerAndMarketing(PartnerAndMarketing partnerAndMarketing) {
		this.partnerAndMarketing = partnerAndMarketing;
	}
	


}
