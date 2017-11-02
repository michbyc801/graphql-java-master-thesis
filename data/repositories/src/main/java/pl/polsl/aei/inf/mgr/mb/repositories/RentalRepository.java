package pl.polsl.aei.inf.mgr.mb.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;

import pl.polsl.aei.inf.mgr.mb.model.ActorEntity;
import pl.polsl.aei.inf.mgr.mb.model.InventoryEntity;
import pl.polsl.aei.inf.mgr.mb.model.RentalEntity;

@Repository
public interface RentalRepository extends EntityGraphJpaRepository<RentalEntity, Integer>
{
	List<RentalEntity> findAllByInventory(InventoryEntity inventoryEntity);

	List<RentalEntity> findAllByInventory_InventoryId(Integer inventoryId);
}
