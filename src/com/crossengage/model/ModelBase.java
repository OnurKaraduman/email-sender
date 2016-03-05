package com.crossengage.model;

import java.util.UUID;

public class ModelBase {
	private String id;
	private Boolean active;

	public ModelBase(String id, Boolean active) {
		super();
		this.id = id;
		this.active = active;
	}

	public ModelBase() {
		super();
		this.id = generateUUID();
		this.active = Boolean.TRUE;

	}

	private String generateUUID() {
		UUID idGenerated = UUID.randomUUID();
		return idGenerated.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
