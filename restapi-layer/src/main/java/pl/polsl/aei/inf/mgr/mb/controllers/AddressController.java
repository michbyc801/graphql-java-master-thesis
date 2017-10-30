package pl.polsl.aei.inf.mgr.mb.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pl.polsl.aei.inf.mgr.mb.model.AddressEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.AddressRepository;

@RestController
@Api("Address Controller")
@RequestMapping(value = "/addresses", method = RequestMethod.GET)
public class AddressController
{
	@Autowired
	private AddressRepository addressRepository;

	@RequestMapping
	public List<AddressEntity> getAllAddresses()
	{
		return addressRepository.findAll();
	}

	@RequestMapping("/{id}")
	public AddressEntity getAddressById(@PathVariable final Integer id)
	{
		return addressRepository.findOne(id);
	}

}
