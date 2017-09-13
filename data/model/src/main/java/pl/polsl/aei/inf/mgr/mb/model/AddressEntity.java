package pl.polsl.aei.inf.mgr.mb.model;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class AddressEntity
{
	private short addressId;
	private String address;
	private String address2;
	private String district;
	private CityEntity city;
	private String postalCode;
	private String phone;
	private Timestamp lastUpdate;

	@Id
	@javax.persistence.Column(name = "address_id")
	public short getAddressId()
	{
		return addressId;
	}

	public void setAddressId(final short addressId)
	{
		this.addressId = addressId;
	}

	@Basic
	@javax.persistence.Column(name = "address")
	public String getAddress()
	{
		return address;
	}

	public void setAddress(final String address)
	{
		this.address = address;
	}

	@Basic
	@javax.persistence.Column(name = "address2")
	public String getAddress2()
	{
		return address2;
	}

	public void setAddress2(final String address2)
	{
		this.address2 = address2;
	}

	@Basic
	@javax.persistence.Column(name = "district")
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
	@javax.persistence.Column(name = "postal_code")
	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(final String postalCode)
	{
		this.postalCode = postalCode;
	}

	@Basic
	@javax.persistence.Column(name = "phone")
	public String getPhone()
	{
		return phone;
	}

	public void setPhone(final String phone)
	{
		this.phone = phone;
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
}
