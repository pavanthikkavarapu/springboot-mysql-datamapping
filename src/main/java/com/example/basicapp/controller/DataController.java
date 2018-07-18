package com.example.basicapp.controller;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicapp.model.AuditSummaryReport;
import com.example.basicapp.service.AuditSummaryReportSevice;

@RestController
public class DataController {

	@Autowired
	public AuditSummaryReportSevice auditSummaryReportSevice;

	
	@GetMapping("/getcoverPage")
	public AuditSummaryReport coverPageInfo(@RequestParam("poolInstanceId") int poolInstanceId,
			@RequestParam("reportType") String reportType) throws  JSONException, IOException, java.text.ParseException {
		AuditSummaryReport ReportData = auditSummaryReportSevice.getAuditSummaryReport(poolInstanceId, reportType);
		//final String uri = "http://localhost:8090/generateAuditPdf";
		//RestTemplate restTemplate = new RestTemplate();
		//restTemplate.postForObject(uri, ReportData, AuditSummaryReport.class);
		return ReportData;
		
	}
}
