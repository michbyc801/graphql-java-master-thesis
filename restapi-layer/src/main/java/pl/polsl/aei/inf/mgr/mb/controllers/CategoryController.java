package pl.polsl.aei.inf.mgr.mb.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.Api;
import pl.polsl.aei.inf.mgr.mb.model.CategoryEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.CategoryRepository;

@RestController
@Api("Category Controller")
@RequestMapping(value = "/categories", method = RequestMethod.GET)
public class CategoryController
{
	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping
	public List<CategoryEntity> getAllCategories()
	{
		return categoryRepository.findAll();
	}

	@RequestMapping("/{id}")
	public CategoryEntity getCategoryById(@PathVariable final Integer id)
	{
		return categoryRepository.findOne(id);
	}

}
