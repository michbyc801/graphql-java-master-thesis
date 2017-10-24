package pl.polsl.aei.inf.mgr.mb.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "actor")
//@formatter:off
@NamedEntityGraphs(value = {
		@NamedEntityGraph(name = "Actor.films", attributeNodes = {@NamedAttributeNode("films")})
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "actorId")
//@formatter:on
public class ActorEntity
{
	private int actorId;
	private String firstName;
	private String lastName;
	private Timestamp lastUpdate;
	private List<FilmEntity> films = new ArrayList<>();

	@Id
	@Column(name = "actor_id")
	public int getActorId()
	{
		return actorId;
	}

	public void setActorId(final int actorId)
	{
		this.actorId = actorId;
	}

	@Basic
	@Column(name = "first_name")
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	@Basic
	@Column(name = "last_name")
	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	@Basic
	@Column(name = "last_update")
	public Timestamp getLastUpdate()
	{
		return lastUpdate;
	}

	public void setLastUpdate(final Timestamp lastUpdate)
	{
		this.lastUpdate = lastUpdate;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	public List<FilmEntity> getFilms()
	{
		return films;
	}

	public void setFilms(final List<FilmEntity> films)
	{
		this.films = films;
	}
}
