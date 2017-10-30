package pl.polsl.aei.inf.mgr.mb.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pl.polsl.aei.inf.mgr.mb.model.StaffEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.StaffRepository;

@RestController
@Api("Staff Controller")
@RequestMapping(value = "/staff", method = RequestMethod.GET)
public class StaffController
{
	@Autowired
	private StaffRepository staffRepository;

	@RequestMapping
	public List<StaffEntity> getAllStaff()
	{
		return staffRepository.findAll();
	}

	@RequestMapping("/{id}")
	public StaffEntity getStaffById(@PathVariable final Integer id)
	{
		return staffRepository.findOne(id);
	}

}
