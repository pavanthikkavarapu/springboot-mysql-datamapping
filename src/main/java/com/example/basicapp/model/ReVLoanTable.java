package com.example.basicapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReVLoanTable {
	@JsonProperty("LoanNumber")
private String LoanNumber;
	@JsonProperty("RevVerficationType")
private String RevVerficationType;
	@JsonProperty("Borrower")
private String Borrower;
	@JsonProperty("RevRecipient")
private String RevRecipient;
	@JsonProperty("RevOrdered_Reordered")
private String RevOrdered_Reordered;
	@JsonProperty("RevResult")
private String RevResult;
public String getLoanNumber() {
	return LoanNumber;
}
public void setLoanNumber(String loanNumber) {
	LoanNumber = loanNumber;
}
public String getRevVerficationType() {
	return RevVerficationType;
}
public void setRevVerficationType(String revVerficationType) {
	RevVerficationType = revVerficationType;
}
public String getBorrower() {
	return Borrower;
}
public void setBorrower(String borrower) {
	Borrower = borrower;
}
public String getRevRecipient() {
	return RevRecipient;
}
public void setRevRecipient(String revRecipient) {
	RevRecipient = revRecipient;
}
public String getRevOrdered_Reordered() {
	return RevOrdered_Reordered;
}
public void setRevOrdered_Reordered(String revOrdered_Reordered) {
	RevOrdered_Reordered = revOrdered_Reordered;
}
public String getRevResult() {
	return RevResult;
}
public void setRevResult(String revResult) {
	RevResult = revResult;
}

}
