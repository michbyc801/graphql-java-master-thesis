package pl.polsl.aei.inf.mgr.mb.graphql.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.coxautodev.graphql.tools.GraphQLResolver;

import pl.polsl.aei.inf.mgr.mb.model.AddressEntity;
import pl.polsl.aei.inf.mgr.mb.model.InventoryEntity;
import pl.polsl.aei.inf.mgr.mb.model.StaffEntity;
import pl.polsl.aei.inf.mgr.mb.model.StoreEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.InventoryRepository;
import pl.polsl.aei.inf.mgr.mb.repositories.StoreRepository;

@Component
public class StoreResolver implements GraphQLResolver<StoreEntity>
{

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private InventoryRepository inventoryRepository;

	StaffEntity getManager(final StoreEntity store)
	{
		return storeRepository.findOne(store.getStoreId(), EntityGraphUtils.fromName("Store.manager")).getManager();
	}

	AddressEntity getAddress(final StoreEntity store)
	{
		return storeRepository.findOne(store.getStoreId(), EntityGraphUtils.fromName("Store.address")).getAddress();
	}

	List<InventoryEntity> getInventories(final StoreEntity store)
	{
		return inventoryRepository.findAllByStore(store);
	}
}
