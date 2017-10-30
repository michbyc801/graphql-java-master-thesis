package pl.polsl.aei.inf.mgr.mb.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pl.polsl.aei.inf.mgr.mb.model.LanguageEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.LanguageRepository;

@RestController
@Api("Language Controller")
@RequestMapping(value = "/languages", method = RequestMethod.GET)
public class LanguageController
{
	@Autowired
	private LanguageRepository languageRepository;

	@RequestMapping
	public List<LanguageEntity> getAllLanguages()
	{
		return languageRepository.findAll();
	}

	@RequestMapping("/{id}")
	public LanguageEntity getLanguageById(@PathVariable final Integer id)
	{
		return languageRepository.findOne(id);
	}

}
