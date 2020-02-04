package com.scp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scp.beans.AddressBean;
import com.scp.service.AddressService;
import com.scp.utils.GenericMessages;

//http://localhost:8080/bankapi-rest/bank/address
@RestController
@RequestMapping("bank/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	static {
		System.out.println("Inside Address Controller...!");
	}

	// all address
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<AddressBean> fetchEntities() {
		return addressService.getAllAddress();
	}

	@GetMapping(value = "/{addressId}")
	// latest
	public ResponseEntity<?> fetchEntity(@PathVariable("addressId") int addressId) {
		AddressBean addressB = addressService.getAddress(addressId);
		if (addressB != null) {
			return new ResponseEntity<>(addressB, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(new GenericMessages("5555", "Invalid ID"),HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> saveEntity(@RequestBody AddressBean addressBean) {
		AddressBean bean = addressService.save(addressBean);
		return new ResponseEntity<>(new GenericMessages("1111", "Success.."),HttpStatus.OK);
	}

	@RequestMapping(value = "/{addressId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAddress(@RequestBody AddressBean addressBean,@PathVariable("addressId") int addressId) {
		AddressBean addressB = addressService.updateAddress(addressBean,addressId);
		if(addressB != null){
			return  new ResponseEntity<>(addressB,HttpStatus.OK);
		}else
			return new ResponseEntity<>(new GenericMessages("5555", "Invlal ID.."),HttpStatus.FORBIDDEN);
	}
}
