package pl.polsl.aei.inf.mgr.mb.model;

import java.math.BigDecimal;
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


@Entity
@Table(name = "payment")
//@formatter:off
@NamedEntityGraphs(value = {
		@NamedEntityGraph(name = "Payment.customer", attributeNodes = {@NamedAttributeNode("customer")}),
		@NamedEntityGraph(name = "Payment.staff", attributeNodes = {@NamedAttributeNode("staff")}),
		@NamedEntityGraph(name = "Payment.rental", attributeNodes = {@NamedAttributeNode("rental")})
})
//@formatter:on
public class PaymentEntity
{
	private int paymentId;
	private CustomerEntity customer;
	private RentalEntity rental;
	private StaffEntity staff;
	private BigDecimal amount;
	private Timestamp paymentDate;
	private Timestamp lastUpdate;

	@Id
	@Column(name = "payment_id")
	public int getPaymentId()
	{
		return paymentId;
	}

	public void setPaymentId(final int paymentId)
	{
		this.paymentId = paymentId;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rental_id")
	public RentalEntity getRental()
	{
		return rental;
	}

	public void setRental(final RentalEntity rental)
	{
		this.rental = rental;
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
	@Column(name = "amount")
	public BigDecimal getAmount()
	{
		return amount;
	}

	public void setAmount(final BigDecimal amount)
	{
		this.amount = amount;
	}

	@Basic
	@Column(name = "payment_date")
	public Timestamp getPaymentDate()
	{
		return paymentDate;
	}

	public void setPaymentDate(final Timestamp paymentDate)
	{
		this.paymentDate = paymentDate;
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
