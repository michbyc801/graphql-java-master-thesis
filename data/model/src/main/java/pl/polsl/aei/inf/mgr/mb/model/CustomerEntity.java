package pl.polsl.aei.inf.mgr.mb.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
@javax.persistence.Table(name = "customer")
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
	private List<RentalEntity> rentals = new ArrayList<>();

	@Id
	@javax.persistence.Column(name = "customer_id")
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
	public StoreEntity getStore()
	{
		return store;
	}

	public void setStore(final StoreEntity store)
	{
		this.store = store;
	}

	@Basic
	@javax.persistence.Column(name = "first_name")
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	@Basic
	@javax.persistence.Column(name = "last_name")
	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	@Basic
	@javax.persistence.Column(name = "email")
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
	@javax.persistence.Column(name = "active")
	public byte getActive()
	{
		return active;
	}

	public void setActive(final byte active)
	{
		this.active = active;
	}

	@Basic
	@javax.persistence.Column(name = "create_date")
	public Timestamp getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(final Timestamp createDate)
	{
		this.createDate = createDate;
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
			mappedBy = "customer",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	public List<RentalEntity> getRentals()
	{
		return rentals;
	}

	public void setRentals(final List<RentalEntity> rentals)
	{
		this.rentals = rentals;
	}
}
