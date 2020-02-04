package com.scp.dao;

import java.util.List;

import com.scp.entities.AddressEntity;

public interface AddressDao {
	public List<AddressEntity> getAllAddress();
	public AddressEntity getAddress(int addressId);
	public AddressEntity save(AddressEntity address);
	public AddressEntity updateAddress(AddressEntity address,int addressId);
	public String delete(int addressId);
}
