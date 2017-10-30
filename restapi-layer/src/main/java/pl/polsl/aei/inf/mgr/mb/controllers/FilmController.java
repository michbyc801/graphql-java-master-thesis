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
import pl.polsl.aei.inf.mgr.mb.model.FilmEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.FilmRepository;

@RestController
@Api("Film Controller")
@RequestMapping(value = "/films", method = RequestMethod.GET)
public class FilmController
{
	@Autowired
	private FilmRepository filmRepository;

	@RequestMapping
	public List<FilmEntity> getAllFilms()
	{
		return filmRepository.findAll();
	}

	@RequestMapping("/{id}")
	public FilmEntity getFilmById(@PathVariable final Integer id)
	{
		return filmRepository.findOne(id);
	}

}
