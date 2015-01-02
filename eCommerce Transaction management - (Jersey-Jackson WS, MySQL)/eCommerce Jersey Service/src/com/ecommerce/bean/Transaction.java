package com.ecommerce.bean;

public class Transaction {

	private String order_id;
	private String user_id;
	private String address_id;
	private String payment_id;
	private String order_placed_timestamp;
	private String order_updated_timestamp;
	private String is_cancelled;
	
	public Transaction(String order_id, String user_id, String address_id,
			String payment_id, String order_placed_timestamp,
			String order_updated_timestamp, String is_cancelled) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.address_id = address_id;
		this.payment_id = payment_id;
		this.order_placed_timestamp = order_placed_timestamp;
		this.order_updated_timestamp = order_updated_timestamp;
		this.is_cancelled = is_cancelled;
	}

	public Transaction() {
		super();
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public String getOrder_placed_timestamp() {
		return order_placed_timestamp;
	}

	public void setOrder_placed_timestamp(String order_placed_timestamp) {
		this.order_placed_timestamp = order_placed_timestamp;
	}

	public String getOrder_updated_timestamp() {
		return order_updated_timestamp;
	}

	public void setOrder_updated_timestamp(String order_updated_timestamp) {
		this.order_updated_timestamp = order_updated_timestamp;
	}

	public String getIs_cancelled() {
		return is_cancelled;
	}

	public void setIs_cancelled(String is_cancelled) {
		this.is_cancelled = is_cancelled;
	}
}
