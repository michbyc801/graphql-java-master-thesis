package pl.polsl.aei.inf.mgr.mb.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pl.polsl.aei.inf.mgr.mb.model.RentalEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.RentalRepository;

@RestController
@Api("Rental Controller")
@RequestMapping(value = "/rentals", method = RequestMethod.GET)
public class RentalController
{
	@Autowired
	private RentalRepository rentalRepository;

	@RequestMapping
	public List<RentalEntity> getAllRentals()
	{
		return rentalRepository.findAll();
	}

	@RequestMapping("/{id}")
	public RentalEntity getRentalById(@PathVariable final Integer id)
	{
		return rentalRepository.findOne(id);
	}

	@RequestMapping("/inventory/{inventoryId}")
	public List<RentalEntity> getRentalsByInventoryId(@PathVariable final Integer inventoryId)
	{
		return rentalRepository.findAllByInventory_InventoryId(inventoryId);
	}
}
