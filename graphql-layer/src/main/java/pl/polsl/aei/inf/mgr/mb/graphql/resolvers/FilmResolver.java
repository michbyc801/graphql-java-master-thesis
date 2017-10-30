package pl.polsl.aei.inf.mgr.mb.graphql.resolvers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.coxautodev.graphql.tools.GraphQLResolver;

import pl.polsl.aei.inf.mgr.mb.model.ActorEntity;
import pl.polsl.aei.inf.mgr.mb.model.CategoryEntity;
import pl.polsl.aei.inf.mgr.mb.model.FilmEntity;
import pl.polsl.aei.inf.mgr.mb.model.InventoryEntity;
import pl.polsl.aei.inf.mgr.mb.model.LanguageEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.FilmRepository;
import pl.polsl.aei.inf.mgr.mb.repositories.InventoryRepository;

@Component
public class FilmResolver implements GraphQLResolver<FilmEntity>
{
	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private InventoryRepository inventoryRepository;

	List<ActorEntity> getActors(final FilmEntity film)
	{
		return filmRepository.findOne(film.getFilmId(), EntityGraphUtils.fromName("Film.actors")).getActors();
	}

	List<CategoryEntity> getCategories(final FilmEntity film)
	{
		return filmRepository.findOne(film.getFilmId(), EntityGraphUtils.fromName("Film.categories")).getCategories();
	}

	LanguageEntity getLanguage(final FilmEntity film)
	{
		return filmRepository.findOne(film.getFilmId(), EntityGraphUtils.fromName("Film.language")).getLanguage();
	}

	LanguageEntity getOriginalLanguage(final FilmEntity film)
	{
		return filmRepository.findOne(film.getFilmId(), EntityGraphUtils.fromName("Film.originalLanguage"))
				.getOriginalLanguage();
	}

	List<InventoryEntity> getInventories(final FilmEntity filmEntity)
	{
		return inventoryRepository.findAllByFilm(filmEntity);
	}
}
