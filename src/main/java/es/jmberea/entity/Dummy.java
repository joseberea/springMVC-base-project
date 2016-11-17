package es.jmberea.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DUMMY")
@SuppressWarnings("serial")
public class Dummy implements Serializable {

	@Id
	@Column(name = "ID_DUMMY")
	private Integer idDummy;

	@Column(name = "DESCRIPTION")
	private String description;

	public Integer getIdDummy() {
		return idDummy;
	}

	public void setIdDummy(Integer idDummy) {
		this.idDummy = idDummy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
