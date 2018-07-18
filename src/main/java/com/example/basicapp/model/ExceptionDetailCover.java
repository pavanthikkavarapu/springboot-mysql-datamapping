package com.example.basicapp.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExceptionDetailCover implements Serializable{
	/**
	 * 
	 */
	
	@JsonProperty(value = "submittedDate", access = Access.WRITE_ONLY)
	private String OrderDate;

public String getOrderDate() {
	return OrderDate;
}

public void setOrderDate(String orderDate) {
	OrderDate = orderDate;
}
}
