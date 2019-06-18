package com.spring.transaction.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.transaction.aspect.TrackTime;
import com.spring.transaction.model.Address;
import com.spring.transaction.service.AddressService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@RestController
@RequestMapping(value="/address/custom/")
public class AddressController {

	@Autowired private AddressService addressService;
	
	@TrackTime
	@PostMapping(path = "/save")
	public @ResponseBody ResponseEntity<Object> save(@RequestBody(required=true) Address Address) throws Exception {
		String message = addressService.save(Address);
		return new ResponseEntity<Object>(message, HttpStatus.CREATED);
	}
	
	@TrackTime
	@PostMapping(path = "/saveAll")
	public @ResponseBody ResponseEntity<Object> saveAll(@RequestBody(required=true) List<Address> Addresss) throws Exception {
		List<Address> list = addressService.saveAll(Addresss);
		return new ResponseEntity<Object>(list, HttpStatus.CREATED);
	}

	@PostMapping(path = "/update")
	public @ResponseBody ResponseEntity<Object> update(@RequestBody Address Address) throws Exception {
		String message = addressService.update(Address);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@PostMapping(path = "/deleteById")
	public @ResponseBody ResponseEntity<Object> deleteById(@RequestParam(required = true, value = "addressId") ObjectId addressId) throws Exception {
		String message = addressService.deleteById(addressId);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@GetMapping(path = "/getAddressById")
	public @ResponseBody ResponseEntity<Object> getAddressById(@RequestParam(required = true, value = "addressId") ObjectId addressId) throws Exception {
		Address Address = addressService.getAddressById(addressId);
		return new ResponseEntity<Object>(Address, HttpStatus.OK);
	}
}
