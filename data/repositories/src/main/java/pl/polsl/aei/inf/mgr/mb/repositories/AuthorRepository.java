package pl.polsl.aei.inf.mgr.mb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import pl.polsl.aei.inf.mgr.mb.model.Author;

@Component
public interface AuthorRepository extends CrudRepository<Author, Integer>
{
}
