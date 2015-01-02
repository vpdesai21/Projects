package com.ecommerce.bean;

public class Inventory {

	String product_id;
	String product_count;
	String update_timestamp;
	
	public Inventory(String product_id, String product_count,
			String update_timestamp) {
		super();
		this.product_id = product_id;
		this.product_count = product_count;
		this.update_timestamp = update_timestamp;
	}
	
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	
	public String getProduct_count() {
		return product_count;
	}
	public void setProduct_count(String product_count) {
		this.product_count = product_count;
	}
	
	public String getUpdate_timestamp() {
		return update_timestamp;
	}
	public void setUpdate_timestamp(String update_timestamp) {
		this.update_timestamp = update_timestamp;
	}
}
