package pl.polsl.aei.inf.mgr.mb.graphql.resolvers;

import java.util.List;

import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.coxautodev.graphql.tools.GraphQLResolver;

import pl.polsl.aei.inf.mgr.mb.model.CategoryEntity;
import pl.polsl.aei.inf.mgr.mb.model.FilmEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.CategoryRepository;

@Component
public class CategoryResolver implements GraphQLResolver<CategoryEntity>
{
	@Autowired
	private CategoryRepository categoryRepository;

	List<FilmEntity> getFilms(final CategoryEntity category)
	{
		try
		{
			return category.films();
		}
		catch (final LazyInitializationException ex)
		{
			return categoryRepository.findOne(category.getCategoryId(), EntityGraphUtils.fromName("Category.filmsRel")).films();
		}
	}
}
