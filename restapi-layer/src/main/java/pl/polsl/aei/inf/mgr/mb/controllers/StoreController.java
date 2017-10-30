package pl.polsl.aei.inf.mgr.mb.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pl.polsl.aei.inf.mgr.mb.model.StoreEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.StoreRepository;

@RestController
@Api("Store Controller")
@RequestMapping(value = "/stores", method = RequestMethod.GET)
public class StoreController
{
	@Autowired
	private StoreRepository storeRepository;

	@RequestMapping
	public List<StoreEntity> getAllStores()
	{
		return storeRepository.findAll();
	}

	@RequestMapping("/{id}")
	public StoreEntity getStoreById(@PathVariable final Integer id)
	{
		return storeRepository.findOne(id);
	}

}
