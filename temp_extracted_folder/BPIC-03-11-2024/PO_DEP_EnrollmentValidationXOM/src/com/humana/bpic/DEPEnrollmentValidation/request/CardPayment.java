package com.humana.bpic.DEPEnrollmentValidation.request;

public class CardPayment {
	private String cardHolderName="";
	private String cardExpirationDate="";
	private String cardToken="";
	private String cardTypeCode="";
	
	public String getCardHolderName() {
	return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
	this.cardHolderName = cardHolderName;
	}

	public String getCardExpirationDate() {
	return cardExpirationDate;
	}
	public void setCardExpirationDate(String cardExpirationDate) {
	this.cardExpirationDate = cardExpirationDate;
	}
	public String getCardToken() {
	return cardToken;
	}
	public void setCardToken(String cardToken) {
	this.cardToken = cardToken;
	}
	public String getCardTypeCode() {
	return cardTypeCode;
	}
	public void setCardTypeCode(String cardTypeCode) {
	this.cardTypeCode = cardTypeCode;
	}

}
