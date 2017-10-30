package pl.polsl.aei.inf.mgr.mb.graphql.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.coxautodev.graphql.tools.GraphQLResolver;

import pl.polsl.aei.inf.mgr.mb.model.FilmEntity;
import pl.polsl.aei.inf.mgr.mb.model.InventoryEntity;
import pl.polsl.aei.inf.mgr.mb.model.RentalEntity;
import pl.polsl.aei.inf.mgr.mb.model.StoreEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.InventoryRepository;
import pl.polsl.aei.inf.mgr.mb.repositories.RentalRepository;

@Component
public class InventoryResolver implements GraphQLResolver<InventoryEntity>
{

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private RentalRepository rentalRepository;

	StoreEntity getStore(final InventoryEntity inventory)
	{
		return inventoryRepository.findOne(inventory.getInventoryId(), EntityGraphUtils.fromName("Inventory.store")).getStore();
	}

	FilmEntity getFilm(final InventoryEntity inventory)
	{
		return inventoryRepository.findOne(inventory.getInventoryId(), EntityGraphUtils.fromName("Inventory.film")).getFilm();
	}

	List<RentalEntity> getRentals(final InventoryEntity inventoryEntity)
	{
		return rentalRepository.findAllByInventory(inventoryEntity);
	}
}
