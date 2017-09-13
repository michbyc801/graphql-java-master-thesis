package pl.polsl.aei.inf.mgr.mb.model;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "language")
public class LanguageEntity
{
	private int languageId;
	private String name;
	private Timestamp lastUpdate;

	@Id
	@Column(name = "language_id")
	public int getLanguageId()
	{
		return languageId;
	}

	public void setLanguageId(final int languageId)
	{
		this.languageId = languageId;
	}

	@Basic
	@Column(name = "name")
	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
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
