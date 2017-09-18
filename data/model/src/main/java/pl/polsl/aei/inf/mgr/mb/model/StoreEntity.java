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
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "store")
//@formatter:off
@NamedEntityGraphs(value = {
		@NamedEntityGraph(name = "Store.manager", attributeNodes = {@NamedAttributeNode("manager")}),
		@NamedEntityGraph(name = "Store.address", attributeNodes = {@NamedAttributeNode("address")}),
		@NamedEntityGraph(name = "Store.customers", attributeNodes = {@NamedAttributeNode("customers")}),
		@NamedEntityGraph(name = "Store.staff", attributeNodes = {@NamedAttributeNode("staff")})
})
//@formatter:on
public class StoreEntity
{
	private int storeId;
	private StaffEntity manager;
	private AddressEntity address;
	private Timestamp lastUpdate;
	private List<CustomerEntity> customers = new ArrayList<>();
	private List<StaffEntity> staff = new ArrayList<>();

	@Id
	@Column(name = "store_id")
	public int getStoreId()
	{
		return storeId;
	}

	public void setStoreId(final int storeId)
	{
		this.storeId = storeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_staff_id")
	public StaffEntity getManager()
	{
		return manager;
	}

	public void setManager(final StaffEntity manager)
	{
		this.manager = manager;
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
	@Column(name = "last_update")
	public Timestamp getLastUpdate()
	{
		return lastUpdate;
	}

	public void setLastUpdate(final Timestamp lastUpdate)
	{
		this.lastUpdate = lastUpdate;
	}

	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<CustomerEntity> getCustomers()
	{
		return customers;
	}

	public void setCustomers(final List<CustomerEntity> customers)
	{
		this.customers = customers;
	}

	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<StaffEntity> getStaff()
	{
		return staff;
	}

	public void setStaff(final List<StaffEntity> staff)
	{
		this.staff = staff;
	}
}
