package pl.polsl.aei.inf.mgr.mb.repositories;

import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;

import pl.polsl.aei.inf.mgr.mb.model.ActorEntity;

@Repository
public interface ActorRepository extends EntityGraphJpaRepository<ActorEntity, Integer>
{
}
