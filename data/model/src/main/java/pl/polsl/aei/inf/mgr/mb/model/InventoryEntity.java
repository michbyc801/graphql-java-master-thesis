package pl.polsl.aei.inf.mgr.mb.model;

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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "inventory")
//@formatter:off
@NamedEntityGraphs(value = {
		@NamedEntityGraph(name = "Inventory.store", attributeNodes = {@NamedAttributeNode("store")}),
		@NamedEntityGraph(name = "Inventory.film", attributeNodes = {@NamedAttributeNode("film")})
})
//@formatter:on
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "inventoryId")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer"})
public class InventoryEntity
{
	private int inventoryId;
	private FilmEntity film;
	private StoreEntity store;
	private Timestamp lastUpdate;

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
}
