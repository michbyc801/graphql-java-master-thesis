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
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "address")
//@formatter:off
@NamedEntityGraphs(value = {
		@NamedEntityGraph(name = "Address.city", attributeNodes = {@NamedAttributeNode("city")})
})
//@formatter:on
public class AddressEntity
{
	private int addressId;
	private String address;
	private String address2;
	private String district;
	private CityEntity city;
	private String postalCode;
	private String phone;
	private Timestamp lastUpdate;

	@Id
	@Column(name = "address_id")
	public int getAddressId()
	{
		return addressId;
	}

	public void setAddressId(final int addressId)
	{
		this.addressId = addressId;
	}

	@Basic
	@Column(name = "address")
	public String getAddress()
	{
		return address;
	}

	public void setAddress(final String address)
	{
		this.address = address;
	}

	@Basic
	@Column(name = "address2")
	public String getAddress2()
	{
		return address2;
	}

	public void setAddress2(final String address2)
	{
		this.address2 = address2;
	}

	@Basic
	@Column(name = "district")
	public String getDistrict()
	{
		return district;
	}

	public void setDistrict(final String district)
	{
		this.district = district;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	public CityEntity getCity()
	{
		return city;
	}

	public void setCity(final CityEntity city)
	{
		this.city = city;
	}

	@Basic
	@Column(name = "postal_code")
	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(final String postalCode)
	{
		this.postalCode = postalCode;
	}

	@Basic
	@Column(name = "phone")
	public String getPhone()
	{
		return phone;
	}

	public void setPhone(final String phone)
	{
		this.phone = phone;
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
