package es.jmberea.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DummyVO implements Serializable {

	private Integer idDummy;
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
