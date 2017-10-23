package pl.polsl.aei.inf.mgr.mb.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "film")
//@formatter:off
@NamedEntityGraphs(value = {
		@NamedEntityGraph(name = "Film.actorsRel", attributeNodes = {@NamedAttributeNode("actorsRel")}),
		@NamedEntityGraph(name = "Film.categoriesRel", attributeNodes = {@NamedAttributeNode("categoriesRel")}),
		@NamedEntityGraph(name = "Film.language", attributeNodes = {@NamedAttributeNode("language")}),
		@NamedEntityGraph(name = "Film.originalLanguage", attributeNodes = {@NamedAttributeNode("originalLanguage")})
})
//@formatter:on
public class FilmEntity
{
	private int filmId;
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
	@Column(name = "film_id")
	public int getFilmId()
	{
		return filmId;
	}

	public void setFilmId(final int filmId)
	{
		this.filmId = filmId;
	}

	@Basic
	@Column(name = "title")
	public String getTitle()
	{
		return title;
	}

	public void setTitle(final String title)
	{
		this.title = title;
	}

	@Basic
	@Column(name = "description")
	public String getDescription()
	{
		return description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	@Basic
	@Column(name = "release_year")
	public String getReleaseYear()
	{
		return releaseYear;
	}

	public void setReleaseYear(final String releaseYear)
	{
		this.releaseYear = releaseYear;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "language_id")
	public LanguageEntity getLanguage()
	{
		return language;
	}

	public void setLanguage(final LanguageEntity language)
	{
		this.language = language;
	}

	@ManyToOne(fetch = FetchType.LAZY)
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
	@Column(name = "rental_duration")
	public byte getRentalDuration()
	{
		return rentalDuration;
	}

	public void setRentalDuration(final byte rentalDuration)
	{
		this.rentalDuration = rentalDuration;
	}

	@Basic
	@Column(name = "rental_rate")
	public BigDecimal getRentalRate()
	{
		return rentalRate;
	}

	public void setRentalRate(final BigDecimal rentalRate)
	{
		this.rentalRate = rentalRate;
	}

	@Basic
	@Column(name = "length")
	public Short getLength()
	{
		return length;
	}

	public void setLength(final Short length)
	{
		this.length = length;
	}

	@Basic
	@Column(name = "replacement_cost")
	public BigDecimal getReplacementCost()
	{
		return replacementCost;
	}

	public void setReplacementCost(final BigDecimal replacementCost)
	{
		this.replacementCost = replacementCost;
	}

	@Basic
	@Column(name = "rating")
	public String getRating()
	{
		return rating;
	}

	public void setRating(final String rating)
	{
		this.rating = rating;
	}

	@Basic
	@Column(name = "special_features")
	public String getSpecialFeatures()
	{
		return specialFeatures;
	}

	public void setSpecialFeatures(final String specialFeatures)
	{
		this.specialFeatures = specialFeatures;
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

	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<FilmActorRel> getActorsRel()
	{
		return actorsRel;
	}

	public void setActorsRel(final Set<FilmActorRel> actorsRel)
	{
		this.actorsRel = actorsRel;
	}

	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
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

	public List<CategoryEntity> categories()
	{
		return categoriesRel.stream().map(FilmCategoryRel::getCategory).collect(Collectors.toList());
	}
}
