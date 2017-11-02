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
@javax.persistence.Table(name = "customer")
//@formatter:off
@NamedEntityGraphs(value = {
		@NamedEntityGraph(name = "Customer.store", attributeNodes = {@NamedAttributeNode("store")}),
		@NamedEntityGraph(name = "Customer.address", attributeNodes = {@NamedAttributeNode("address")})
})
//@formatter:on
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer"})
public class CustomerEntity
{
	private int customerId;
	private StoreEntity store;
	private String firstName;
	private String lastName;
	private String email;
	private AddressEntity address;
	private byte active;
	private Timestamp createDate;
	private Timestamp lastUpdate;

	@Id
	@Column(name = "customer_id")
	public int getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(final int customerId)
	{
		this.customerId = customerId;
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
	@Column(name = "create_date")
	public Timestamp getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(final Timestamp createDate)
	{
		this.createDate = createDate;
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
