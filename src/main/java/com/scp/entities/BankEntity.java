package com.scp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Bank_Info")
public class BankEntity {

	@Id
	private int bankId;
	private String bankName;
	private String active;
	
	//one bank has many customer.
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="Bank_Customer_Join",
			joinColumns=@JoinColumn(
					name="bankId", unique=false,
					referencedColumnName="bankId"),
			inverseJoinColumns=@JoinColumn(
					name="customerId", unique=true,
					referencedColumnName="customerId")
			)
	private List<CustomerEntity> custEntity;

	public BankEntity(int bankId, String bankName, String active,
			List<CustomerEntity> custEntity) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.active = active;
		this.custEntity = custEntity;
	}

	public BankEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public List<CustomerEntity> getCustEntity() {
		return custEntity;
	}

	public void setCustEntity(List<CustomerEntity> custEntity) {
		this.custEntity = custEntity;
	}

	@Override
	public String toString() {
		return "BankEntity [bankId=" + bankId + ", bankName=" + bankName
				+ ", active=" + active + ", custEntity=" + custEntity + "]";
	}
	
	

}
