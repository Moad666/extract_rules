package com.humana.bpic.DEPEnrollmentValidation.request;

public class BankPayment {

	private String bankAccountBankName="";
	private String bankAccountHolderName="";
	private String bankAccountType="";
	private String bankAccountNumber="";
	private String bankAccountTransitNumber="";
	public String getBankAccountBankName() {
		return bankAccountBankName;
	}
	public void setBankAccountBankName(String bankAccountBankName) {
		this.bankAccountBankName = bankAccountBankName;
	}
	public String getBankAccountHolderName() {
		return bankAccountHolderName;
	}
	public void setBankAccountHolderName(String bankAccountHolderName) {
		this.bankAccountHolderName = bankAccountHolderName;
	}
	public String getBankAccountType() {
		return bankAccountType;
	}
	public void setBankAccountType(String bankAccountType) {
		this.bankAccountType = bankAccountType;
	}
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}
	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	public String getBankAccountTransitNumber() {
		return bankAccountTransitNumber;
	}
	public void setBankAccountTransitNumber(String bankAccountTransitNumber) {
		this.bankAccountTransitNumber = bankAccountTransitNumber;
	}
	
}
