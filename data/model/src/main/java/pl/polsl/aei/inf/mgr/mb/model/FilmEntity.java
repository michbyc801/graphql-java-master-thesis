package pl.polsl.aei.inf.mgr.mb.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;


@Entity
public class FilmEntity
{
	private short filmId;
	private String title;
	private String description;
	private String releaseYear;
	private LanguageEntity language;
	private LanguageEntity originalLanguage;
	private byte rentalDuration;
	private BigDecimal rentalRate;
	private Short length;
	private BigDecimal replacementCost;
	private String rating;
	private String specialFeatures;
	private Timestamp lastUpdate;
	private Set<FilmActorRel> actorsRel;
	private Set<FilmCategoryRel> categoriesRel;

	@Id
	@javax.persistence.Column(name = "film_id")
	public short getFilmId()
	{
		return filmId;
	}

	public void setFilmId(final short filmId)
	{
		this.filmId = filmId;
	}

	@Basic
	@javax.persistence.Column(name = "title")
	public String getTitle()
	{
		return title;
	}

	public void setTitle(final String title)
	{
		this.title = title;
	}

	@Basic
	@javax.persistence.Column(name = "description")
	public String getDescription()
	{
		return description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	@Basic
	@javax.persistence.Column(name = "release_year")
	public String getReleaseYear()
	{
		return releaseYear;
	}

	public void setReleaseYear(final String releaseYear)
	{
		this.releaseYear = releaseYear;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "language_id")
	public LanguageEntity getLanguage()
	{
		return language;
	}

	public void setLanguage(final LanguageEntity language)
	{
		this.language = language;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "original_language_id")
	public LanguageEntity getOriginalLanguage()
	{
		return originalLanguage;
	}

	public void setOriginalLanguage(final LanguageEntity originalLanguage)
	{
		this.originalLanguage = originalLanguage;
	}

	@Basic
	@javax.persistence.Column(name = "rental_duration")
	public byte getRentalDuration()
	{
		return rentalDuration;
	}

	public void setRentalDuration(final byte rentalDuration)
	{
		this.rentalDuration = rentalDuration;
	}

	@Basic
	@javax.persistence.Column(name = "rental_rate")
	public BigDecimal getRentalRate()
	{
		return rentalRate;
	}

	public void setRentalRate(final BigDecimal rentalRate)
	{
		this.rentalRate = rentalRate;
	}

	@Basic
	@javax.persistence.Column(name = "length")
	public Short getLength()
	{
		return length;
	}

	public void setLength(final Short length)
	{
		this.length = length;
	}

	@Basic
	@javax.persistence.Column(name = "replacement_cost")
	public BigDecimal getReplacementCost()
	{
		return replacementCost;
	}

	public void setReplacementCost(final BigDecimal replacementCost)
	{
		this.replacementCost = replacementCost;
	}

	@Basic
	@javax.persistence.Column(name = "rating")
	public String getRating()
	{
		return rating;
	}

	public void setRating(final String rating)
	{
		this.rating = rating;
	}

	@Basic
	@javax.persistence.Column(name = "special_features")
	public String getSpecialFeatures()
	{
		return specialFeatures;
	}

	public void setSpecialFeatures(final String specialFeatures)
	{
		this.specialFeatures = specialFeatures;
	}

	@Basic
	@javax.persistence.Column(name = "last_update")
	public Timestamp getLastUpdate()
	{
		return lastUpdate;
	}

	public void setLastUpdate(final Timestamp lastUpdate)
	{
		this.lastUpdate = lastUpdate;
	}

	@OneToMany(
			mappedBy = "film",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	public Set<FilmActorRel> getActorsRel()
	{
		return actorsRel;
	}

	@OneToMany(
			mappedBy = "film",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	public Set<FilmCategoryRel> getCategoriesRel()
	{
		return categoriesRel;
	}

	public void setCategoriesRel(final Set<FilmCategoryRel> categoriesRel)
	{
		this.categoriesRel = categoriesRel;
	}

	public List<ActorEntity> actors()
	{
		return actorsRel.stream().map(FilmActorRel::getActor).collect(Collectors.toList());
	}

	public List<CategoryEntity> categories(){return categoriesRel.stream().map(FilmCategoryRel::getCategoryEntity).collect(Collectors.toList());}
}
