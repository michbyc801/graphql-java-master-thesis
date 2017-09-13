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
@javax.persistence.Table(name = "staff")
public class StaffEntity
{
	private byte staffId;
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
	private List<PaymentEntity> payments = new ArrayList<>();
	private List<RentalEntity> rentals = new ArrayList<>();

	@Id
	@javax.persistence.Column(name = "staff_id")
	public byte getStaffId()
	{
		return staffId;
	}

	public void setStaffId(final byte staffId)
	{
		this.staffId = staffId;
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
	@javax.persistence.Column(name = "picture", length = 65535)
	public byte[] getPicture()
	{
		return picture;
	}

	public void setPicture(final byte[] picture)
	{
		this.picture = picture;
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
	@javax.persistence.Column(name = "username")
	public String getUsername()
	{
		return username;
	}

	public void setUsername(final String username)
	{
		this.username = username;
	}

	@Basic
	@javax.persistence.Column(name = "password")
	public String getPassword()
	{
		return password;
	}

	public void setPassword(final String password)
	{
		this.password = password;
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
			mappedBy = "staff",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	public List<PaymentEntity> getPayments()
	{
		return payments;
	}

	public void setPayments(final List<PaymentEntity> payments)
	{
		this.payments = payments;
	}

	@OneToMany(
			mappedBy = "staff",
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
