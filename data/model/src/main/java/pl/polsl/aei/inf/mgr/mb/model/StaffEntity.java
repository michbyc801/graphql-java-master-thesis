package pl.polsl.aei.inf.mgr.mb.model;

import java.sql.Timestamp;

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
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@javax.persistence.Table(name = "staff")
//@formatter:off
@NamedEntityGraphs(value = {
		@NamedEntityGraph(name = "Staff.address", attributeNodes = {@NamedAttributeNode("address")}),
		@NamedEntityGraph(name = "Staff.store", attributeNodes = {@NamedAttributeNode("store")})
})
//@formatter:on
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer"})
public class StaffEntity
{
	private int staffId;
	private String firstName;
	private String lastName;
	private AddressEntity address;
	private byte[] picture;
	private String email;
	private StoreEntity store;
	private byte active;
	private String username;
	private String password;
	private Timestamp lastUpdate;

	@Id
	@Column(name = "staff_id")
	public int getStaffId()
	{
		return staffId;
	}

	public void setStaffId(final int staffId)
	{
		this.staffId = staffId;
	}

	@Basic
	@Column(name = "first_name")
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	@Basic
	@Column(name = "last_name")
	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	public AddressEntity getAddress()
	{
		return address;
	}

	public void setAddress(final AddressEntity address)
	{
		this.address = address;
	}

	@Basic
	@Column(name = "picture", length = 65535)
	public byte[] getPicture()
	{
		return picture;
	}

	public void setPicture(final byte[] picture)
	{
		this.picture = picture;
	}

	@Basic
	@Column(name = "email")
	public String getEmail()
	{
		return email;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	@JsonBackReference
	public StoreEntity getStore()
	{
		return store;
	}

	public void setStore(final StoreEntity store)
	{
		this.store = store;
	}

	@Basic
	@Column(name = "active")
	public byte getActive()
	{
		return active;
	}

	public void setActive(final byte active)
	{
		this.active = active;
	}

	@Basic
	@Column(name = "username")
	public String getUsername()
	{
		return username;
	}

	public void setUsername(final String username)
	{
		this.username = username;
	}

	@Basic
	@Column(name = "password")
	public String getPassword()
	{
		return password;
	}

	public void setPassword(final String password)
	{
		this.password = password;
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

	@Transient
	public Integer getStoreId()
	{
		return getStore().getStoreId();
	}
}
