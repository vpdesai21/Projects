package com.ecommerce.bean;

public class Product {

	private String order_id;
	private String product_id;
	private String product_quantity;
	public Product(String order_id, String product_id, String product_quantity) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.product_quantity = product_quantity;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(String product_quantity) {
		this.product_quantity = product_quantity;
	}
}
