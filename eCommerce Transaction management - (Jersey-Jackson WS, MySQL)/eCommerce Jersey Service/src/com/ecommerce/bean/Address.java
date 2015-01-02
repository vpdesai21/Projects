package com.ecommerce.bean;

public class Address {

	private String address_id;
	private String user_id;
	private String address_line1;
	private String address_line2;
	private String city;
	private String state;
	private String zipcode;
	private String is_primary;
	
	public Address(String address_id, String user_id, String address_line1,
			String address_line2, String city, String state, String zipcode,
			String is_primary) {
		super();
		this.address_id = address_id;
		this.user_id = user_id;
		this.address_line1 = address_line1;
		this.address_line2 = address_line2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.is_primary = is_primary;
	}
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getAddress_id() {
		return address_id;
	}
	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAddress_line1() {
		return address_line1;
	}
	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}
	public String getAddress_line2() {
		return address_line2;
	}
	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getIs_primary() {
		return is_primary;
	}
	public void setIs_primary(String is_primary) {
		this.is_primary = is_primary;
	}
	
}
