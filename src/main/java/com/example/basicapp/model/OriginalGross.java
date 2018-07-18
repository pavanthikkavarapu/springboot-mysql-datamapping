package com.example.basicapp.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class OriginalGross implements Serializable {

	private static final long serialVersionUID = 1L;  
	
	@JsonProperty("totalExceptions")	
    private int totalExceptions;
	@JsonIgnore
	@JsonProperty("CriticalExceptionsPercent")
	private float CriticalExceptionsPercent;
	@JsonIgnore
	@JsonProperty("NonCriticalExceptionsPercent")
	private float NonCriticalExceptionsPercent;
	@JsonProperty("totalExceptions")
	private int ExceptionRatingTable;
	@JsonProperty("totalExceptions")
	private int ExceptionsByCategoryTable;
public int getTotalExceptions() {
	return totalExceptions;
}
public void setTotalExceptions(int totalExceptions) {
	this.totalExceptions = totalExceptions;
}
public float getCriticalExceptionsPercent() {
	return CriticalExceptionsPercent;
}
public void setCriticalExceptionsPercent(float criticalExceptionsPercent) {
	CriticalExceptionsPercent = criticalExceptionsPercent;
}
public float getNonCriticalExceptionsPercent() {
	return NonCriticalExceptionsPercent;
}
public void setNonCriticalExceptionsPercent(float nonCriticalExceptionsPercent) {
	NonCriticalExceptionsPercent = nonCriticalExceptionsPercent;
}
public int getExceptionRatingTable() {
	return ExceptionRatingTable;
}
public void setExceptionRatingTable(int exceptionRatingTable) {
	ExceptionRatingTable = exceptionRatingTable;
}
public int getExceptionsByCategoryTable() {
	return ExceptionsByCategoryTable;
}
public void setExceptionsByCategoryTable(int exceptionsByCategoryTable) {
	ExceptionsByCategoryTable = exceptionsByCategoryTable;
}


}
