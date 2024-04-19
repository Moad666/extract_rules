package com.humana.bpic.DEPEnrollmentValidation.request;

public class Diabetes {
	private boolean hasHighBloodSugar;
	private boolean hasInsulinOralMedication;
	private boolean monitorsBloodSugar;
	public boolean isHasHighBloodSugar() {
		return hasHighBloodSugar;
	}
	public void setHasHighBloodSugar(boolean hasHighBloodSugar) {
		this.hasHighBloodSugar = hasHighBloodSugar;
	}
	public boolean isHasInsulinOralMedication() {
		return hasInsulinOralMedication;
	}
	public void setHasInsulinOralMedication(boolean hasInsulinOralMedication) {
		this.hasInsulinOralMedication = hasInsulinOralMedication;
	}
	public boolean isMonitorsBloodSugar() {
		return monitorsBloodSugar;
	}
	public void setMonitorsBloodSugar(boolean monitorsBloodSugar) {
		this.monitorsBloodSugar = monitorsBloodSugar;
	}

}
