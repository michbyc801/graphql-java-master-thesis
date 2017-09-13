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
	private FilmEntity filmEntity;
	private CategoryEntity categoryEntity;
	private Timestamp lastUpdate;

	@Id
	@ManyToOne
	@JoinColumn(name = "film_id")
	public FilmEntity getFilmEntity()
	{
		return filmEntity;
	}

	public void setFilmEntity(final FilmEntity filmEntity)
	{
		this.filmEntity = filmEntity;
	}

	@Id
	@ManyToOne
	@JoinColumn(name = "category_id")
	public CategoryEntity getCategoryEntity()
	{
		return categoryEntity;
	}

	public void setCategoryEntity(final CategoryEntity categoryEntity)
	{
		this.categoryEntity = categoryEntity;
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
