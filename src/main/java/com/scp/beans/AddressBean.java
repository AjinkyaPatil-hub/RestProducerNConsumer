package com.scp.beans;

public class AddressBean {

	private int addressId;
	private String city;
	private String active;
	public AddressBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddressBean(int addressId, String city, String active) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.active = active;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "AddressBean [addressId=" + addressId + ", city=" + city
				+ ", active=" + active + "]";
	}

	  
}
