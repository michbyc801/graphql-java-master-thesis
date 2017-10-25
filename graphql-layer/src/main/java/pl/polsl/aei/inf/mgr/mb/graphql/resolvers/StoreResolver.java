package pl.polsl.aei.inf.mgr.mb.graphql.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.coxautodev.graphql.tools.GraphQLResolver;

import pl.polsl.aei.inf.mgr.mb.model.AddressEntity;
import pl.polsl.aei.inf.mgr.mb.model.StaffEntity;
import pl.polsl.aei.inf.mgr.mb.model.StoreEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.StoreRepository;

@Component
public class StoreResolver implements GraphQLResolver<StoreEntity>
{

	@Autowired
	private StoreRepository storeRepository;

	StaffEntity getManager(final StoreEntity store)
	{
		return storeRepository.findOne(store.getStoreId(), EntityGraphUtils.fromName("Store.manager")).getManager();
	}

	AddressEntity getAddress(final StoreEntity store)
	{
		return storeRepository.findOne(store.getStoreId(), EntityGraphUtils.fromName("Store.address")).getAddress();
	}
}
