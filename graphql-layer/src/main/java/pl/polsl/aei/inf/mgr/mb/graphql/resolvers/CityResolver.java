package pl.polsl.aei.inf.mgr.mb.graphql.resolvers;

import java.util.List;

import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.coxautodev.graphql.tools.GraphQLResolver;

import pl.polsl.aei.inf.mgr.mb.model.AddressEntity;
import pl.polsl.aei.inf.mgr.mb.model.CityEntity;
import pl.polsl.aei.inf.mgr.mb.model.CountryEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.CityRepository;

@Component
public class CityResolver implements GraphQLResolver<CityEntity>
{
	@Autowired
	private CityRepository cityRepository;

	List<AddressEntity> getAddresses(final CityEntity cityEntity)
	{
		try
		{
			return cityEntity.getAddresses();
		}
		catch (LazyInitializationException ex)
		{
			return cityRepository.findOne(cityEntity.getCityId(), EntityGraphUtils.fromName("City.addresses")).getAddresses();
		}
	}

	CountryEntity getCountry(final CityEntity cityEntity)
	{
		return cityRepository.findOne(cityEntity.getCityId()).getCountry();
	}
}
