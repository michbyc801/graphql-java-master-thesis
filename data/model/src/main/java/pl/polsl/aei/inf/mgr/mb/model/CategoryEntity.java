package pl.polsl.aei.inf.mgr.mb.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "category")
//@formatter:off
@NamedEntityGraphs(value = {
		@NamedEntityGraph(name = "Category.films", attributeNodes = {@NamedAttributeNode("films")})
})
//@formatter:on
public class CategoryEntity
{

	private int categoryId;
	private String name;
	private Timestamp lastUpdate;
	private List<FilmEntity> films = new ArrayList<>();

	@Id
	@Column(name = "category_id")
	public int getCategoryId()
	{
		return categoryId;
	}

	public void setCategoryId(final int categoryId)
	{
		this.categoryId = categoryId;
	}

	@Basic
	@Column(name = "name")
	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
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
	@JsonBackReference
	public List<FilmEntity> getFilms()
	{
		return films;
	}

	public void setFilms(final List<FilmEntity> films)
	{
		this.films = films;
	}
}
