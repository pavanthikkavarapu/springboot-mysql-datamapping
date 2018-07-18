package com.example.basicapp.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;





@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditResultsSection implements Serializable {
	
		
	private int LoanCountExceptions;
	
	@JsonProperty(value = "countOfLoans", access = Access.WRITE_ONLY)
	private int LoanCountSelected;
	
	/*@JsonProperty(value = "id", access = Access.WRITE_ONLY)*/
	private int CleanLoansCount;
	
	private int TotalExceptions;
	
	private float CriticalExceptionsPercent;
	
	private float NonCriticalExceptionsPercent;
	
	private int OrdersWithSomeEx;
	
	private int OrdersWithCriticalEx;
	
	private int OrderWithNonCriticalEx;

	public int getTotalExceptions() {
		return TotalExceptions;
	}
	public void setTotalExceptions(int totalExceptions) {
		TotalExceptions = totalExceptions;
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
	
	public int getOrdersWithSomeEx() {
		return OrdersWithSomeEx;
	}
	public void setOrdersWithSomeEx(int ordersWithSomeEx) {
		OrdersWithSomeEx = ordersWithSomeEx;
	}
	
	public int getOrdersWithCriticalEx() {
		return OrdersWithCriticalEx;
	}
	public void setOrdersWithCriticalEx(int ordersWithCriticalEx) {
		OrdersWithCriticalEx = ordersWithCriticalEx;
	}
	
	public int getOrderWithNonCriticalEx() {
		return OrderWithNonCriticalEx;
	}
	public void setOrderWithNonCriticalEx(int orderWithNonCriticalEx) {
		OrderWithNonCriticalEx = orderWithNonCriticalEx;
	}
	
	public int getLoanCountExceptions() {
		return LoanCountExceptions;
	}
	public void setLoanCountExceptions(int loanCountExceptions) {
		LoanCountExceptions = loanCountExceptions;
	}
	
	public int getLoanCountSelected() {
		return LoanCountSelected;
	}
	public void setLoanCountSelected(int loanCountSelected) {
		LoanCountSelected = loanCountSelected;
	}
	
	public int getCleanLoansCount() {
		return CleanLoansCount;
	}
	public void setCleanLoansCount(int cleanLoansCount) {
		CleanLoansCount = cleanLoansCount;
	}
	
	
}
