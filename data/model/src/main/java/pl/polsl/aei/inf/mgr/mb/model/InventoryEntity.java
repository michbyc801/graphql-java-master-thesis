package pl.polsl.aei.inf.mgr.mb.model;

import java.sql.Timestamp;
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
@Table(name = "inventory")
public class InventoryEntity
{
	private int inventoryId;
	private FilmEntity film;
	private StoreEntity store;
	private Timestamp lastUpdate;
	private List<RentalEntity> rentals;

	@Id
	@Column(name = "inventory_id")
	public int getInventoryId()
	{
		return inventoryId;
	}

	public void setInventoryId(final int inventoryId)
	{
		this.inventoryId = inventoryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id")
	public FilmEntity getFilm()
	{
		return film;
	}

	public void setFilm(final FilmEntity film)
	{
		this.film = film;
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
			mappedBy = "inventory",
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
