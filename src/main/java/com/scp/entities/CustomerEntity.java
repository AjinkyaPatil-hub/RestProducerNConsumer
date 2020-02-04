package com.scp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_Info")
public class CustomerEntity {

	@Id
	private int customerId;
	private String customerName;
	private String active;
	
	//many  customer has many address
	@ManyToMany
	@JoinTable(
			name="Customer_Address_Join",
			joinColumns=@JoinColumn(
					name="customerId", unique=false,
					referencedColumnName="customerId"),
			inverseJoinColumns=@JoinColumn(
					name="addressId", unique=false,
					referencedColumnName="addressId")
			)
	private List<AddressEntity> addrEntity;

	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerEntity(int customerId, String customerName, String active,
			List<AddressEntity> addrEntity) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.active = active;
		this.addrEntity = addrEntity;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public List<AddressEntity> getAddrEntity() {
		return addrEntity;
	}

	public void setAddrEntity(List<AddressEntity> addrEntity) {
		this.addrEntity = addrEntity;
	}

	@Override
	public String toString() {
		return "CustomerEntity [customerId=" + customerId + ", customerName="
				+ customerName + ", active=" + active + ", addrEntity="
				+ addrEntity + "]";
	}

}
