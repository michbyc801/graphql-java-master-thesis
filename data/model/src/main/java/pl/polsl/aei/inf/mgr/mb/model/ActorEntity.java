package pl.polsl.aei.inf.mgr.mb.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "actor")
public class ActorEntity
{
	private short actorId;
	private String firstName;
	private String lastName;
	private Timestamp lastUpdate;
	private Set<FilmActorRel> filmsRel = new HashSet<>();

	@Id
	@Column(name = "actor_id")
	public short getActorId()
	{
		return actorId;
	}

	public void setActorId(final short actorId)
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

	@OneToMany(
			mappedBy = "actor",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	public Set<FilmActorRel> getFilmsRel()
	{
		return filmsRel;
	}

	public void setFilmsRel(final Set<FilmActorRel> filmsRel)
	{
		this.filmsRel = filmsRel;
	}

	public List<FilmEntity> films()
	{
		return filmsRel.stream().map(FilmActorRel::getFilm).collect(Collectors.toList());
	}
}
