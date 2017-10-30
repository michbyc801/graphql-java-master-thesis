package pl.polsl.aei.inf.mgr.mb.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;

import pl.polsl.aei.inf.mgr.mb.model.ActorEntity;
import pl.polsl.aei.inf.mgr.mb.model.PaymentEntity;
import pl.polsl.aei.inf.mgr.mb.model.RentalEntity;

@Repository
public interface PaymentRepository extends EntityGraphJpaRepository<PaymentEntity, Integer>
{
	List<PaymentEntity> findAllByRental(RentalEntity rentalEntity);
}
