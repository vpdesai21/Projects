package com.ecommerce.bean;

public class PaymentDetails {
	private String payment_id;
	private String user_id;
	private String card_holder_name;
	private String expiration_date;
	private String card_number;
	private String cvv_code;
	
	public PaymentDetails(String payment_id, String user_id,
			String card_holder_name, String expiration_date,
			String card_number, String cvv_code) {
		super();
		this.payment_id = payment_id;
		this.user_id = user_id;
		this.card_holder_name = card_holder_name;
		this.expiration_date = expiration_date;
		this.card_number = card_number;
		this.cvv_code = cvv_code;
	}
	
	public PaymentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCard_holder_name() {
		return card_holder_name;
	}
	public void setCard_holder_name(String card_holder_name) {
		this.card_holder_name = card_holder_name;
	}
	public String getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	public String getCvv_code() {
		return cvv_code;
	}
	public void setCvv_code(String cvv_code) {
		this.cvv_code = cvv_code;
	}
	
	
}
