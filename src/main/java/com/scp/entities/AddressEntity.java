package com.scp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address_Info")
public class AddressEntity {

	@Id
	private int addressId;
	private String city;
	private String active;
	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddressEntity(int addressId, String city, String active) {
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
		return "AddressEntity [addressId=" + addressId + ", city=" + city
				+ ", active=" + active + "]";
	}
	
}
