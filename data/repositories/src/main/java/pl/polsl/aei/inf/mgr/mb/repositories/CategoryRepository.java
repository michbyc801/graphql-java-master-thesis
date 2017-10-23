package pl.polsl.aei.inf.mgr.mb.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;

import pl.polsl.aei.inf.mgr.mb.model.CategoryEntity;

@Repository
public interface CategoryRepository extends EntityGraphJpaRepository<CategoryEntity, Integer>
{
	List<CategoryEntity> getAllByNameContains(final String categoryName);
}
