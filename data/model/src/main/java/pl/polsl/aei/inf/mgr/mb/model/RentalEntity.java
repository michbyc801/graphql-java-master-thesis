package pl.polsl.aei.inf.mgr.mb.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "rental")
//@formatter:off
@NamedEntityGraphs(value = {
		@NamedEntityGraph(name = "Rental.inventory", attributeNodes = {@NamedAttributeNode("inventory")}),
		@NamedEntityGraph(name = "Rental.customer", attributeNodes = {@NamedAttributeNode("customer")}),
		@NamedEntityGraph(name = "Rental.staff", attributeNodes = {@NamedAttributeNode("staff")})
})
//@formatter:on
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer"})
public class RentalEntity
{
	private int rentalId;
	private Timestamp rentalDate;
	private InventoryEntity inventory;
	private CustomerEntity customer;
	private Timestamp returnDate;
	private StaffEntity staff;
	private Timestamp lastUpdate;

	@Id
	@Column(name = "rental_id")
	public int getRentalId()
	{
		return rentalId;
	}

	public void setRentalId(final int rentalId)
	{
		this.rentalId = rentalId;
	}

	@Basic
	@Column(name = "rental_date")
	public Timestamp getRentalDate()
	{
		return rentalDate;
	}

	public void setRentalDate(final Timestamp rentalDate)
	{
		this.rentalDate = rentalDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inventory_id")
	public InventoryEntity getInventory()
	{
		return inventory;
	}

	public void setInventory(final InventoryEntity inventory)
	{
		this.inventory = inventory;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	public CustomerEntity getCustomer()
	{
		return customer;
	}

	public void setCustomer(final CustomerEntity customer)
	{
		this.customer = customer;
	}


	@Basic
	@Column(name = "return_date")
	public Timestamp getReturnDate()
	{
		return returnDate;
	}

	public void setReturnDate(final Timestamp returnDate)
	{
		this.returnDate = returnDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id")
	public StaffEntity getStaff()
	{
		return staff;
	}

	public void setStaff(final StaffEntity staff)
	{
		this.staff = staff;
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
