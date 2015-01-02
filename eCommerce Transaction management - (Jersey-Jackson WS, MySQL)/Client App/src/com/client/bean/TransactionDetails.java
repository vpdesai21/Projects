package com.client.bean;

public class TransactionDetails {

	private String order_id;
	private String product_details;
	private String product_quantity;
	private String shipping_address;
	private String order_date;
	private String order_status;
	
	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	private String is_cancelled;
	
	public TransactionDetails() {
		super();
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getProduct_details() {
		return product_details;
	}

	public void setProduct_details(String product_details) {
		this.product_details = product_details;
	}

	public String getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(String product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}

	public String getIs_cancelled() {
		return is_cancelled;
	}

	public void setIs_cancelled(String is_cancelled) {
		this.is_cancelled = is_cancelled;
	}
}
