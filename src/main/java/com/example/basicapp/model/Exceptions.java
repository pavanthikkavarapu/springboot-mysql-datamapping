package com.example.basicapp.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Exceptions implements Serializable{

	private static final long serialVersionUID = 1L;
	@JsonProperty("OriginalGross")
	private OriginalGross originalGross;
	
	public OriginalGross getOriginalGross() {
		return originalGross;
	}

	public void setOriginalGross(OriginalGross originalGross) {
		this.originalGross = originalGross;
	}
	
}
