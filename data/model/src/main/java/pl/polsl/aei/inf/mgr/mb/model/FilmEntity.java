package pl.polsl.aei.inf.mgr.mb.model;

import java.math.BigDecimal;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "film")
//@formatter:off
@NamedEntityGraphs(value = {
		@NamedEntityGraph(name = "Film.actors", attributeNodes = {@NamedAttributeNode("actors")}),
		@NamedEntityGraph(name = "Film.categories", attributeNodes = {@NamedAttributeNode("categories")}),
		@NamedEntityGraph(name = "Film.language", attributeNodes = {@NamedAttributeNode("language")}),
		@NamedEntityGraph(name = "Film.originalLanguage", attributeNodes = {@NamedAttributeNode("originalLanguage")})
})
//@formatter:on
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "filmId")
@JsonIgnoreProperties(value = {"language","originalLanguage"})
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
	private List<ActorEntity> actors = new ArrayList<>();
	private List<CategoryEntity> categories = new ArrayList<>();

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

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "film_actor", joinColumns = {
			@JoinColumn(name = "film_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "actor_id",
					nullable = false, updatable = false) })
	public List<ActorEntity> getActors()
	{
		return actors;
	}

	public void setActors(final List<ActorEntity> actors)
	{
		this.actors = actors;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "film_category", joinColumns = {
			@JoinColumn(name = "film_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "category_id",
					nullable = false, updatable = false) })
	public List<CategoryEntity> getCategories()
	{
		return categories;
	}

	public void setCategories(final List<CategoryEntity> categories)
	{
		this.categories = categories;
	}
}
