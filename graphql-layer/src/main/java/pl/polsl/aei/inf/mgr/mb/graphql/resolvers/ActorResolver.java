package pl.polsl.aei.inf.mgr.mb.graphql.resolvers;

import java.util.List;
import java.util.Set;

import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.coxautodev.graphql.tools.GraphQLResolver;

import pl.polsl.aei.inf.mgr.mb.model.ActorEntity;
import pl.polsl.aei.inf.mgr.mb.model.FilmEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.ActorRepository;

@Component
public class ActorResolver implements GraphQLResolver<ActorEntity>
{
	@Autowired
	private ActorRepository actorRepository;

	List<FilmEntity> getFilms(final ActorEntity actor)
	{
		return actorRepository.findOne(actor.getActorId(), EntityGraphUtils.fromName("Actor.films")).getFilms();
	}
}
