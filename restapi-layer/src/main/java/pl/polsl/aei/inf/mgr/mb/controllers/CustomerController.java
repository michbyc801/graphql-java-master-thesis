package pl.polsl.aei.inf.mgr.mb.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pl.polsl.aei.inf.mgr.mb.model.CustomerEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.CustomerRepository;

@RestController
@Api("Customer Controller")
@RequestMapping(value = "/customers", method = RequestMethod.GET)
public class CustomerController
{
	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping
	public List<CustomerEntity> getAllCustomers()
	{
		return customerRepository.findAll();
	}

	@RequestMapping("/{id}")
	public CustomerEntity getCustomerById(@PathVariable final Integer id)
	{
		return customerRepository.findOne(id);
	}

}
