package com.humana.bpic.DEPEnrollmentValidation.request;

public class PaymentPreferences {
	private String paymentCategory="";
	private String paymentMethodType="";
	private String paymentFrequency="";
	private double paymentMonthlyPremiumAmount;
	private BankPayment bankPayment;
	private CardPayment cardPayment;
	public String getPaymentCategory() {
		return paymentCategory;
	}
	public void setPaymentCategory(String paymentCategory) {
		this.paymentCategory = paymentCategory;
	}
	public String getPaymentMethodType() {
		return paymentMethodType;
	}
	public void setPaymentMethodType(String paymentMethodType) {
		this.paymentMethodType = paymentMethodType;
	}
	public String getPaymentFrequency() {
		return paymentFrequency;
	}
	public void setPaymentFrequency(String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}

	public double getPaymentMonthlyPremiumAmount() {
		return paymentMonthlyPremiumAmount;
	}
	public void setPaymentMonthlyPremiumAmount(double paymentMonthlyPremiumAmount) {
		this.paymentMonthlyPremiumAmount = paymentMonthlyPremiumAmount;
	}
	public BankPayment getBankPayment() {
		return bankPayment;
	}
	public void setBankPayment(BankPayment bankPayment) {
		this.bankPayment = bankPayment;
	}
	public CardPayment getCardPayment() {
		return cardPayment;
	}
	public void setCardPayment(CardPayment cardPayment) {
		this.cardPayment = cardPayment;
	}
}
