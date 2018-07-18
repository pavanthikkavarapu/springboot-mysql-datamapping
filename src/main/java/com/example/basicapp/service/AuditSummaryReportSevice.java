package com.example.basicapp.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.basicapp.dao.SpringDAO;
import com.example.basicapp.model.AuditResultsSection;
import com.example.basicapp.model.AuditSelection;
import com.example.basicapp.model.AuditSummaryPage;
import com.example.basicapp.model.AuditSummaryReport;
import com.example.basicapp.model.CoverPage;
import com.example.basicapp.model.ExceptionDetailCover;
import com.example.basicapp.model.Exceptions;
import com.example.basicapp.model.OriginalGross;
import com.example.basicapp.model.ReVLoanTable;
import com.example.basicapp.model.ReVerificationCover;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AuditSummaryReportSevice{
	
	@Autowired
	public SpringDAO dao;
	
	List<String> orderConditionList = null;
	
	public void setOrderConditionList(List<String> orderConditionList) {
		this.orderConditionList = orderConditionList;
	}

	public AuditSummaryReport getAuditSummaryReport(int poolInstanceId, String reportType) throws JSONException, IOException, ParseException {
		
		List<String> ordersList = dao.getOrderList(poolInstanceId, reportType);
		
		
		int ordersWithCriticalExCount = 0;
		int ordersWithSomeExCount = 0; 
		int orderWithNonCriticalExCount = 0;
		int totalExceptionsCount = 0;
		float criticalExPercent = 0L;
		float nonCriticalExceptionsPercent = 0L;
		int loanCountExceptions = 0;
		int CleanLoansCount=0;
		int ExceptionRatingTable=0;
	
		
		String orderId = null;
		for(String order: ordersList) {
			JSONObject orderObj = new JSONObject(order);
			orderId = orderObj.get("orderId").toString();
		
			dao.getOrderConditionList(orderId);
			
			int conditionsWithCriticalExCount = 0;
			int conditionsWithSomeExCount = 0;
			int conditionsWithNonCriticalExCount = 0;
			
		
			for(String value: orderConditionList) {
				JSONObject jsonObj1 = new JSONObject(value);
				String conditionSeverityLevel = jsonObj1.get("conditionSeverityLevel").toString();
				if(conditionSeverityLevel.equalsIgnoreCase("EV1") || conditionSeverityLevel.equalsIgnoreCase("EV5")) {
					conditionsWithCriticalExCount++;
				}
				if(conditionSeverityLevel.equalsIgnoreCase("EV2") || conditionSeverityLevel.equalsIgnoreCase("EV3") || 
						conditionSeverityLevel.equalsIgnoreCase("EV4") || conditionSeverityLevel.equalsIgnoreCase("EV5")) {
					conditionsWithSomeExCount++;
					totalExceptionsCount++;
					ExceptionRatingTable++;
				}
				if(conditionSeverityLevel.equalsIgnoreCase("EV2") || conditionSeverityLevel.equalsIgnoreCase("EV3")) {
					conditionsWithNonCriticalExCount++;
				}
			}
			
			if(conditionsWithCriticalExCount != 0) {
				ordersWithCriticalExCount++;
			}
			if(conditionsWithSomeExCount != 0) {
				ordersWithSomeExCount++;			
			}
			if(conditionsWithNonCriticalExCount != 0) {
				orderWithNonCriticalExCount++;
			}
			if(totalExceptionsCount != 0) {
				criticalExPercent = conditionsWithCriticalExCount/totalExceptionsCount * 100;
			}
			String initialLoanRating = orderObj.get("initialLoanRating").toString();
			String currentLoanRating = orderObj.get("currentLoanRating").toString();
			if(reportType.equalsIgnoreCase("prelim")) {
				if(initialLoanRating.equalsIgnoreCase("EV2") || initialLoanRating.equalsIgnoreCase("EV3") ||
						initialLoanRating.equalsIgnoreCase("EV4") || initialLoanRating.equalsIgnoreCase("EV5")) {
					loanCountExceptions++;
				}
			} else{
				if(currentLoanRating.equalsIgnoreCase("EV2") || currentLoanRating.equalsIgnoreCase("EV3") ||
						currentLoanRating.equalsIgnoreCase("EV4") || currentLoanRating.equalsIgnoreCase("EV5")) {
					loanCountExceptions++;
				}
			}
			
		}
		nonCriticalExceptionsPercent = 100 - criticalExPercent;
		
		
		String json = ordersList.get(0);
		ObjectMapper mapper = new ObjectMapper();
		JSONObject jsonObj = new JSONObject(json);
		
		CoverPage coverPage = mapper.readValue(jsonObj.toString(),CoverPage.class);
		AuditSelection auditSelection = mapper.readValue(jsonObj.toString(),AuditSelection.class);
		
		AuditResultsSection auditResultsSelection = mapper.readValue(jsonObj.toString(),AuditResultsSection.class);
		auditResultsSelection.setOrdersWithCriticalEx(ordersWithCriticalExCount);
		auditResultsSelection.setOrdersWithSomeEx(ordersWithSomeExCount);
		auditResultsSelection.setOrderWithNonCriticalEx(orderWithNonCriticalExCount);
		auditResultsSelection.setTotalExceptions(totalExceptionsCount);
		auditResultsSelection.setCriticalExceptionsPercent(criticalExPercent);
		auditResultsSelection.setNonCriticalExceptionsPercent(nonCriticalExceptionsPercent);
		auditResultsSelection.setLoanCountExceptions(loanCountExceptions);
		auditResultsSelection.setLoanCountSelected(auditResultsSelection.getLoanCountSelected());
		CleanLoansCount = auditResultsSelection.getLoanCountSelected() - loanCountExceptions;  //CleanLoansCount = LoanCountSelected - LoanCountExceptions
		auditResultsSelection.setCleanLoansCount(CleanLoansCount);
	

		
		
		String originalString = coverPage.getOrderDate();
	    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(originalString);
	    String newstring = new SimpleDateFormat("MMMM yyyy").format(date);
	    coverPage.setOrderDate(newstring);
	    
	    Date today = Calendar.getInstance().getTime();
	    SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
	    String localdate = formatter.format(today);
	    coverPage.setEffectiveDate(localdate);
	    
	    AuditSummaryPage auditSummaryPage = new AuditSummaryPage();
		auditSummaryPage.setAuditResultsSelection(auditResultsSelection);
		auditSummaryPage.setAuditSelection(auditSelection);
		
		
		
		if (auditSelection.getLoanCountAll() != 0) {
			auditSelection.setSamplingPercent(auditSelection.getLoanCountAudited() / auditSelection.getLoanCountAll() * 100);
		}
		
		
		
		
		//Exceptions
		
		OriginalGross originalGross = mapper.readValue(jsonObj.toString(),OriginalGross.class);
		originalGross.setTotalExceptions(totalExceptionsCount);
		originalGross.setCriticalExceptionsPercent(criticalExPercent);
		originalGross.setNonCriticalExceptionsPercent(nonCriticalExceptionsPercent);
		
		originalGross.setExceptionRatingTable(ExceptionRatingTable);
		
		
		
		Exceptions exceptions = new Exceptions();
		exceptions.setOriginalGross(originalGross);
		
		
		//exceptionDetailCover
		
		
		ExceptionDetailCover exceptionDetailCover = mapper.readValue(jsonObj.toString(),ExceptionDetailCover.class);
		exceptionDetailCover.setOrderDate(newstring);
		
		
		//ReVerificationCover
		ReVerificationCover reVerificationCover = mapper.readValue(jsonObj.toString(),ReVerificationCover.class);
		reVerificationCover.setOrderDate(newstring);
	
		//ReVerficationDetail
		
		
		
		ReVLoanTable reVLoanTable = mapper.readValue(jsonObj.toString(),ReVLoanTable.class);
		/*reVLoanTable.setBorrower(borrower);
		reVLoanTable.setLoanNumber(loanNumber);
		reVLoanTable.setRevOrdered_Reordered(revOrdered_Reordered);
		reVLoanTable.setRevResult(revResult);
		reVLoanTable.setRevVerficationType(revVerficationType);
		reVLoanTable.setRevOrdered_Reordered(revOrdered_Reordered);*/
		
		
		AuditSummaryReport auditSummaryReport = new AuditSummaryReport(); 
		auditSummaryReport.setCoverPage(coverPage);
		auditSummaryReport.setAuditSummaryPage(auditSummaryPage);
		auditSummaryReport.setExceptions(exceptions);
		auditSummaryReport.setExceptionDetailCover(exceptionDetailCover);
		auditSummaryReport.setReVerificationCover(reVerificationCover);
		//auditSummaryReport.setReVerficationDetail(reVerficationDetail);
		
		return auditSummaryReport;
	}
	
}