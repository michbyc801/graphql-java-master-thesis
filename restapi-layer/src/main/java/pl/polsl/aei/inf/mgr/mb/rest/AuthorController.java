package pl.polsl.aei.inf.mgr.mb.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.polsl.aei.inf.mgr.mb.model.Author;
import pl.polsl.aei.inf.mgr.mb.repositories.AuthorRepository;

@RestController
@RequestMapping("/author")
public class AuthorController
{

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	Environment env;


	@RequestMapping(method = RequestMethod.GET)
	public Author getAuthor(@RequestParam final Integer id)
	{
		return authorRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createAuthor(final Author author)
	{
		authorRepository.save(author);
	}
}
