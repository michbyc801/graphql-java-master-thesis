package pl.polsl.aei.inf.mgr.mb.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pl.polsl.aei.inf.mgr.mb.model.CityEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.CityRepository;

@RestController
@Api("City Controller")
@RequestMapping(value = "/cities", method = RequestMethod.GET)
public class CityController
{
	@Autowired
	private CityRepository cityRepository;

	@RequestMapping
	public List<CityEntity> getAllCities()
	{
		return cityRepository.findAll();
	}

	@RequestMapping("/{id}")
	public CityEntity getCityById(@PathVariable final Integer id)
	{
		return cityRepository.findOne(id);
	}

}
