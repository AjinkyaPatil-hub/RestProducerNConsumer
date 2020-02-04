package com.scp.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scp.beans.AddressBean;
import com.scp.dao.AddressDao;
import com.scp.entities.AddressEntity;
import com.scp.service.AddressService;

@Service("service")
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressDao dao;

	@Override
	public List<AddressBean> getAllAddress() {
		List<AddressBean> addrBean = new ArrayList<>();
		List<AddressEntity> allAddress = dao.getAllAddress();
		for (AddressEntity addressEntity : allAddress) {
			addrBean.add(convertToBean(addressEntity));
		}
		return addrBean;
	}

	private AddressBean convertToBean(AddressEntity addressEntity) {
		AddressBean addrBean = new AddressBean();
		addrBean.setAddressId(addressEntity.getAddressId());
		addrBean.setCity(addressEntity.getCity());
		addrBean.setActive(addressEntity.getActive());
		return addrBean;
	}

	@Override
	public AddressBean getAddress(int addressID) {
		if (addressID > 0) {
			AddressEntity addressEntity = dao.getAddress(addressID);
			if (addressEntity != null) {
				return convertToBean(addressEntity);
			}
		}
		return null;
	}

	@Override
	public AddressBean save(AddressBean address) {
		return convertToBean(dao.save(convertToEntity(address)));
	}

	@Override
	public AddressBean updateAddress(AddressBean address,int addressId) {
		AddressEntity addrEntiy = dao.updateAddress(convertToEntity(address),addressId);
		if (addrEntiy != null)
			return convertToBean(addrEntiy);
		else
			return null;
	}

	private AddressEntity convertToEntity(AddressBean address) {
		AddressEntity addrEntity = new AddressEntity();
		addrEntity.setAddressId(address.getAddressId());
		addrEntity.setActive(address.getActive());
		addrEntity.setCity(address.getCity());
		return addrEntity;
	}

	@Override
	public String delete(int addressId) {
		dao.delete(addressId);

		return "deleted...";
	}

}
