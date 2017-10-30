package pl.polsl.aei.inf.mgr.mb.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pl.polsl.aei.inf.mgr.mb.model.CountryEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.CountryRepository;

@RestController
@Api("Country Controller")
@RequestMapping(value = "/countries", method = RequestMethod.GET)
public class CountryController
{
	@Autowired
	private CountryRepository countryRepository;

	@RequestMapping
	public List<CountryEntity> getAllCountries()
	{
		return countryRepository.findAll();
	}

	@RequestMapping("/{id}")
	public CountryEntity getCountryById(@PathVariable final Integer id)
	{
		return countryRepository.findOne(id);
	}

}
