package pl.polsl.aei.inf.mgr.mb.graphql.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.coxautodev.graphql.tools.GraphQLResolver;

import pl.polsl.aei.inf.mgr.mb.model.CustomerEntity;
import pl.polsl.aei.inf.mgr.mb.model.InventoryEntity;
import pl.polsl.aei.inf.mgr.mb.model.RentalEntity;
import pl.polsl.aei.inf.mgr.mb.model.StaffEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.RentalRepository;

@Component
public class RentalResolver implements GraphQLResolver<RentalEntity>
{

	@Autowired
	private RentalRepository rentalRepository;

	CustomerEntity getCustomer(final RentalEntity rental)
	{
		return rentalRepository.findOne(rental.getRentalId(), EntityGraphUtils.fromName("Rental.customer")).getCustomer();
	}

	InventoryEntity getInventory(final RentalEntity rental)
	{
		return rentalRepository.findOne(rental.getRentalId(), EntityGraphUtils.fromName("Rental.inventory")).getInventory();
	}

	StaffEntity getStaff(final RentalEntity rental)
	{
		return rentalRepository.findOne(rental.getRentalId(), EntityGraphUtils.fromName("Rental.staff")).getStaff();
	}
}
