package pl.polsl.aei.inf.mgr.mb.graphql.resolvers;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import graphql.schema.DataFetchingEnvironment;
import pl.polsl.aei.inf.mgr.mb.model.ActorEntity;
import pl.polsl.aei.inf.mgr.mb.model.CategoryEntity;
import pl.polsl.aei.inf.mgr.mb.model.CityEntity;
import pl.polsl.aei.inf.mgr.mb.model.CountryEntity;
import pl.polsl.aei.inf.mgr.mb.model.FilmEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.ActorRepository;
import pl.polsl.aei.inf.mgr.mb.repositories.CategoryRepository;
import pl.polsl.aei.inf.mgr.mb.repositories.CityRepository;
import pl.polsl.aei.inf.mgr.mb.repositories.CountryRepository;
import pl.polsl.aei.inf.mgr.mb.repositories.FilmRepository;

@Component
public class QueryResolver implements GraphQLQueryResolver
{
	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CityRepository cityRepository;

	public List<ActorEntity> actor(final Optional<Integer> actorId)
	{
		return actorId.map(integer -> Collections.singletonList(actorRepository.findOne(integer))).orElseGet(
				() -> actorRepository.findAll());
	}

	public List<FilmEntity> film(final Optional<String> filmTitle)
	{
		return filmTitle.map(filmTitleString -> Collections.singletonList(filmRepository.getByTitle(filmTitleString))).orElseGet(
				() -> filmRepository.findAll());
	}

	public List<CategoryEntity> category(final Optional<String> categoryName)
	{
		return categoryName.map(categoryNameString -> categoryRepository.getAllByNameContains(categoryNameString)).orElseGet(
				() -> categoryRepository.findAll());
	}

	public List<CountryEntity> country(final Optional<Integer> countryId)
	{
		return countryId.map(countryIdInt -> Collections.singletonList(countryRepository.findOne(countryIdInt))).orElseGet(
				() -> countryRepository.findAll());
	}

	public List<CityEntity> city(final Optional<Integer> cityId)
	{
		return cityId.map(cityIdInt -> Collections.singletonList(cityRepository.findOne(cityIdInt))).orElseGet(
				() -> cityRepository.findAll());
	}
}
