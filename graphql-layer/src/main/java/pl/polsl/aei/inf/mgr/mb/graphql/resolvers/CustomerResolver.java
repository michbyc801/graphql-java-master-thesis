package pl.polsl.aei.inf.mgr.mb.graphql.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.coxautodev.graphql.tools.GraphQLResolver;

import pl.polsl.aei.inf.mgr.mb.model.AddressEntity;
import pl.polsl.aei.inf.mgr.mb.model.CustomerEntity;
import pl.polsl.aei.inf.mgr.mb.model.RentalEntity;
import pl.polsl.aei.inf.mgr.mb.model.StoreEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.CustomerRepository;

@Component
public class CustomerResolver implements GraphQLResolver<CustomerEntity>
{

	@Autowired
	private CustomerRepository customerRepository;

	StoreEntity getStore(final CustomerEntity customerEntity)
	{
		return customerRepository.findOne(customerEntity.getCustomerId(), EntityGraphUtils.fromName("Customer.store"))
				.getStore();
	}

	List<RentalEntity> getRentals(final CustomerEntity customerEntity)
	{
		return customerRepository.findOne(customerEntity.getCustomerId(), EntityGraphUtils.fromName("Customer.rentals"))
				.getRentals();
	}

	AddressEntity getAddress(final CustomerEntity customerEntity)
	{
		return customerRepository.findOne(customerEntity.getCustomerId(), EntityGraphUtils.fromName("Customer.address"))
				.getAddress();
	}
}
