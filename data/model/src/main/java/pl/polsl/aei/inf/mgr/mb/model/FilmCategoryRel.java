package pl.polsl.aei.inf.mgr.mb.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "film_category")
public class FilmCategoryRel implements Serializable
{
	private FilmEntity film;
	private CategoryEntity category;
	private Timestamp lastUpdate;

	@Id
	@ManyToOne
	@JoinColumn(name = "film_id")
	public FilmEntity getFilm()
	{
		return film;
	}

	public void setFilm(final FilmEntity film)
	{
		this.film = film;
	}

	@Id
	@ManyToOne
	@JoinColumn(name = "category_id")
	public CategoryEntity getCategory()
	{
		return category;
	}

	public void setCategory(final CategoryEntity category)
	{
		this.category = category;
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
}
