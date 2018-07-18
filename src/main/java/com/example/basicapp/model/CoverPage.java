package com.example.basicapp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoverPage implements Serializable {
	
	@JsonProperty("clientCompanyName")
	private String clientCompanyName;
	
	@JsonProperty(value = "submittedDate", access = Access.WRITE_ONLY)
	private String OrderDate;
	
	private String EffectiveDate;
	

	public String getEffectiveDate() {
		return EffectiveDate;
	}

	public void setEffectiveDate(String EffectiveDate) {
		this.EffectiveDate = EffectiveDate;
	}

	public String getClientCompanyName() {
		return clientCompanyName;
	}

	
	public void setClientCompanyName(String clientCompanyName) {
		this.clientCompanyName = clientCompanyName;
	}

		
	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	
	

	
	
}
