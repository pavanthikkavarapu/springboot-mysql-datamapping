package com.example.basicapp.controller;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicapp.LoanData;
import com.example.basicapp.dao.SpringDAO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DataController {

	@Autowired
	public SpringDAO dao;

	@GetMapping("/getcustInfo")
	public LoanData customerInformation(@RequestParam("loanNumber") String loanNumber) throws JSONException, JsonParseException, JsonMappingException, IOException {
		String json = dao.isData(loanNumber);
		ObjectMapper mapper = new ObjectMapper();
		JSONObject jsonObj = new JSONObject(json);
		LoanData loanData = mapper.readValue(jsonObj.toString(),LoanData.class);
		
		return loanData;
		
	}

}
