package com.humana.bpic.DEPEnrollmentValidation.request;

public class CardiovascularDisease {
	private boolean hasCirculationProblems;
	private boolean hasHeartProblems;
	private boolean hasLegPain;
	public boolean isHasCirculationProblems() {
		return hasCirculationProblems;
	}
	public void setHasCirculationProblems(boolean hasCirculationProblems) {
		this.hasCirculationProblems = hasCirculationProblems;
	}
	public boolean isHasHeartProblems() {
		return hasHeartProblems;
	}
	public void setHasHeartProblems(boolean hasHeartProblems) {
		this.hasHeartProblems = hasHeartProblems;
	}
	public boolean isHasLegPain() {
		return hasLegPain;
	}
	public void setHasLegPain(boolean hasLegPain) {
		this.hasLegPain = hasLegPain;
	}

}
