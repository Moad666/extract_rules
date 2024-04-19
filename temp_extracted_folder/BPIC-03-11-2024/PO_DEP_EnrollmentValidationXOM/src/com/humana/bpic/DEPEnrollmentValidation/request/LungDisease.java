package com.humana.bpic.DEPEnrollmentValidation.request;

public class LungDisease {
	private boolean hasBreathingProblem;
	private boolean hasLungProblem;
	private boolean usesInhaler;
	public boolean isHasBreathingProblem() {
		return hasBreathingProblem;
	}
	public void setHasBreathingProblem(boolean hasBreathingProblem) {
		this.hasBreathingProblem = hasBreathingProblem;
	}
	public boolean isHasLungProblem() {
		return hasLungProblem;
	}
	public void setHasLungProblem(boolean hasLungProblem) {
		this.hasLungProblem = hasLungProblem;
	}
	public boolean isUsesInhaler() {
		return usesInhaler;
	}
	public void setUsesInhaler(boolean usesInhaler) {
		this.usesInhaler = usesInhaler;
	}

}

