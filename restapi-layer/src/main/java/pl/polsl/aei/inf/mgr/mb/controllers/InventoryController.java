package pl.polsl.aei.inf.mgr.mb.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pl.polsl.aei.inf.mgr.mb.model.ActorEntity;
import pl.polsl.aei.inf.mgr.mb.model.InventoryEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.ActorRepository;
import pl.polsl.aei.inf.mgr.mb.repositories.InventoryRepository;

@RestController
@Api("Inventory Controller")
@RequestMapping(value = "/inventories", method = RequestMethod.GET)
public class InventoryController
{
	@Autowired
	private InventoryRepository inventoryRepository;

	@RequestMapping
	public List<InventoryEntity> getAllInventories()
	{
		return inventoryRepository.findAll();
	}

	@RequestMapping("/{id}")
	public InventoryEntity getInventoryById(@PathVariable final Integer id)
	{
		return inventoryRepository.findOne(id);
	}

}
