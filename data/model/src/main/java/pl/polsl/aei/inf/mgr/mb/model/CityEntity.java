package pl.polsl.aei.inf.mgr.mb.model;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "city")
//@formatter:off
@NamedEntityGraphs(value = {
		@NamedEntityGraph(name = "City.country", attributeNodes = {@NamedAttributeNode("country")})
})
//@formatter:on
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer"})
public class CityEntity
{
	private int cityId;
	private String city;
	private Timestamp lastUpdate;
	private CountryEntity country;

	@Id
	@Column(name = "city_id")
	public int getCityId()
	{
		return cityId;
	}

	public void setCityId(final int cityId)
	{
		this.cityId = cityId;
	}

	@Basic
	@Column(name = "city")
	public String getCity()
	{
		return city;
	}

	public void setCity(final String city)
	{
		this.city = city;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	public CountryEntity getCountry()
	{
		return country;
	}

	public void setCountry(final CountryEntity country)
	{
		this.country = country;
	}
}
