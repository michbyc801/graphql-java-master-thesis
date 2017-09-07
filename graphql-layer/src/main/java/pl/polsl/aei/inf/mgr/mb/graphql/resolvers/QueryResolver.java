package pl.polsl.aei.inf.mgr.mb.graphql.resolvers;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class QueryResolver implements GraphQLQueryResolver
{
	public String hero(final Optional<String> episode)
	{
		return episode.isPresent() ? episode.get() : new Date().toString();
	}
}
