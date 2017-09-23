package pl.polsl.aei.inf.mgr.mb.repositories;

import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;

import pl.polsl.aei.inf.mgr.mb.model.ActorEntity;
import pl.polsl.aei.inf.mgr.mb.model.CustomerEntity;

@Repository
public interface CustomerRepository extends EntityGraphJpaRepository<CustomerEntity, Integer>
{
}
