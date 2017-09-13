package pl.polsl.aei.inf.mgr.mb.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "country")
public class CountryEntity
{
	private int countryId;
	private String country;
	private Timestamp lastUpdate;
	private List<CityEntity> cities = new ArrayList<>();

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

	@OneToMany(
			mappedBy = "country",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	public List<CityEntity> getCities()
	{
		return cities;
	}

	public void setCities(final List<CityEntity> cities)
	{
		this.cities = cities;
	}
}
