package com.example.basicapp.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoverPage implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("clientCompanyName")
	private String clientCompanyname;
	
	@JsonProperty("submittedDate")
	private String submittedDate;
	
	@JsonProperty(value = "countOfLoans", access = Access.WRITE_ONLY)
	private int LoanCountAll;

	@JsonProperty(value = "countOfReviewedLoans", access = Access.WRITE_ONLY)
	private int LoanCountAudited;
	
	private float SamplingPercent;

	@JsonProperty(value = "contractedServiceSamplingMethod", access = Access.WRITE_ONLY)
	private String SamplingMethod;
	
	public String getSamplingMethod() {
		return SamplingMethod;
	}

	public void setSamplingMethod(String samplingMethod) {
		SamplingMethod = samplingMethod;
	}

	public int getLoanCountAudited() {
		return LoanCountAudited;
	}

	public void setLoanCountAudited(int loanCountAudited) {
		LoanCountAudited = loanCountAudited;
	}

	public float getSamplingPercent() {
		return SamplingPercent;
	}

	public void setSamplingPercent(float samplingPercent) {
		SamplingPercent = samplingPercent;
	}
	
	public int getLoanCountAll() {
		return LoanCountAll;
	}

	public void setLoanCountAll(int loanCountAll) {
		LoanCountAll = loanCountAll;
	}

	public String getClientCompanyName() {
		return clientCompanyname;
	}

	public void setClientCompanyName(String clientCompanyName) {
		this.clientCompanyname = clientCompanyName;
	}

	public String getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}
}
