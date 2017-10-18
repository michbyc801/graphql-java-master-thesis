package pl.polsl.aei.inf.mgr.mb.graphql.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.coxautodev.graphql.tools.GraphQLResolver;

import pl.polsl.aei.inf.mgr.mb.model.CityEntity;
import pl.polsl.aei.inf.mgr.mb.model.CountryEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.CountryRepository;

@Component
public class CountryResolver implements GraphQLResolver<CountryEntity>
{

	@Autowired
	private CountryRepository countryRepository;

	List<CityEntity> getCities(final CountryEntity country)
	{
		return countryRepository.findOne(country.getCountryId(), EntityGraphUtils.fromName("Country.cities")).getCities();
	}
}
