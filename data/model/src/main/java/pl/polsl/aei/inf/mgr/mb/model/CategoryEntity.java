package pl.polsl.aei.inf.mgr.mb.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "category")
public class CategoryEntity
{
	private int categoryId;
	private String name;
	private Timestamp lastUpdate;
	private Set<FilmCategoryRel> filmsRel;

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

	@OneToMany(
			mappedBy = "category",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	public Set<FilmCategoryRel> getFilmsRel()
	{
		return filmsRel;
	}

	public void setFilmsRel(final Set<FilmCategoryRel> filmsRel)
	{
		this.filmsRel = filmsRel;
	}

	public List<FilmEntity> films()
	{
		return filmsRel.stream().map(FilmCategoryRel::getFilmEntity).collect(Collectors.toList());
	}
}
