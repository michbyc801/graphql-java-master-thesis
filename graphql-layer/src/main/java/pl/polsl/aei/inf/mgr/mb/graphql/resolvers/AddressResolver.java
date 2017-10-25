package pl.polsl.aei.inf.mgr.mb.graphql.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.coxautodev.graphql.tools.GraphQLResolver;

import pl.polsl.aei.inf.mgr.mb.model.AddressEntity;
import pl.polsl.aei.inf.mgr.mb.model.CityEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.AddressRepository;

@Component
public class AddressResolver implements GraphQLResolver<AddressEntity>
{
	@Autowired
	private AddressRepository addressRepository;

	CityEntity getCity(final AddressEntity addressEntity)
	{
		return addressRepository.findOne(addressEntity.getAddressId(), EntityGraphUtils.fromName("Address.city")).getCity();
	}
}
