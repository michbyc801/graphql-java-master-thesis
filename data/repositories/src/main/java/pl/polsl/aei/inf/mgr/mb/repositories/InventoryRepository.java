package pl.polsl.aei.inf.mgr.mb.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;

import pl.polsl.aei.inf.mgr.mb.model.ActorEntity;
import pl.polsl.aei.inf.mgr.mb.model.FilmEntity;
import pl.polsl.aei.inf.mgr.mb.model.InventoryEntity;
import pl.polsl.aei.inf.mgr.mb.model.StoreEntity;

@Repository
public interface InventoryRepository extends EntityGraphJpaRepository<InventoryEntity, Integer>
{
	List<InventoryEntity> findAllByFilm(final FilmEntity film);

	List<InventoryEntity> findAllByStore(StoreEntity store);
}
