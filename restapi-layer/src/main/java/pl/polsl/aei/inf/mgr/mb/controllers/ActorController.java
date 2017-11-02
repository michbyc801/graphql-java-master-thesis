package pl.polsl.aei.inf.mgr.mb.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pl.polsl.aei.inf.mgr.mb.model.ActorEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.ActorRepository;
import pl.polsl.aei.inf.mgr.mb.repositories.FilmRepository;

@RestController
@Api("Actor Controller")
@RequestMapping(value = "/actors", method = RequestMethod.GET)
public class ActorController
{
	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private FilmRepository filmRepository;

	@RequestMapping
	public List<ActorEntity> getAllActors()
	{
		return actorRepository.findAll();
	}

	@RequestMapping("/{id}")
	public ActorEntity getActorById(@PathVariable final Integer id)
	{
		final ActorEntity one = actorRepository.findOne(id);
		return one;
	}

	@RequestMapping("/film")
	public List<ActorEntity> getActorsByFilmId(@RequestParam final Integer filmId)
	{
		return filmRepository.findOne(filmId).getActors();
	}

}
