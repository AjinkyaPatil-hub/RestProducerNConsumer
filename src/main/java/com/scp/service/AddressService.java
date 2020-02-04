package com.scp.service;

import java.util.List;

import com.scp.beans.AddressBean;

public interface AddressService {

	public List<AddressBean> getAllAddress();
	public AddressBean getAddress(int addressID);
	public AddressBean save(AddressBean address);
	public AddressBean updateAddress(AddressBean address,int addressId);
	public String delete(int addressId);
}
