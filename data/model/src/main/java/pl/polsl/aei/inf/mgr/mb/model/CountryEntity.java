package pl.polsl.aei.inf.mgr.mb.model;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "country")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer"})
public class CountryEntity
{
	private int countryId;
	private String country;
	private Timestamp lastUpdate;

	@Id
	@Column(name = "country_id")
	public int getCountryId()
	{
		return countryId;
	}

	public void setCountryId(final int countryId)
	{
		this.countryId = countryId;
	}

	@Basic
	@Column(name = "country")
	public String getCountry()
	{
		return country;
	}

	public void setCountry(final String country)
	{
		this.country = country;
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
