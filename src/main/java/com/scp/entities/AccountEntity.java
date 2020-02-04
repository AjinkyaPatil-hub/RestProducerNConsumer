package com.scp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Account_Info")
public class AccountEntity {

	@Id
	private int accountId;
	private String accountType;
	private String active;

	//one customer has one account.
		@OneToOne
		@JoinTable(
				name="Account_Customer_Join",
				joinColumns=@JoinColumn(
						name="accountId", unique=false,
						referencedColumnName="accountId"),
				inverseJoinColumns=@JoinColumn(
						name="customerId", unique=false,
						referencedColumnName="customerId")
				)
		private CustomerEntity custEntity;

	public AccountEntity(int accountId, String accountType, String active,
			CustomerEntity custEntity) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.active = active;
		this.custEntity = custEntity;
	}

	public AccountEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public CustomerEntity getCustEntity() {
		return custEntity;
	}

	public void setCustEntity(CustomerEntity custEntity) {
		this.custEntity = custEntity;
	}

	@Override
	public String toString() {
		return "AccountEntity [accountId=" + accountId + ", accountType="
				+ accountType + ", active=" + active + ", custEntity="
				+ custEntity + "]";
	}

		
}
