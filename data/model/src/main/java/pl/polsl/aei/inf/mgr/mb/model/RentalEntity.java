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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "rental")
public class RentalEntity
{
	private int rentalId;
	private Timestamp rentalDate;
	private InventoryEntity inventory;
	private CustomerEntity customer;
	private Timestamp returnDate;
	private StaffEntity staff;
	private Timestamp lastUpdate;
	private List<PaymentEntity> payments = new ArrayList<>();

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

	@OneToMany(
			mappedBy = "rental",
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
}
