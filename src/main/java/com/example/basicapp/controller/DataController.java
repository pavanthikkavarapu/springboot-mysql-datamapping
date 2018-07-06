package com.example.basicapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicapp.model.Borrower;
import com.example.basicapp.model.Data;
import com.example.basicapp.model.JsonObject;
import com.example.basicapp.model.LoanApplication;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.*;

import com.example.basicapp.LoanData;
import com.example.basicapp.dao.SpringDAO;

@RestController
public class DataController {

	@Autowired
	public SpringDAO dao;

	@GetMapping("/getcustInfo")
	public LoanData customerInformation() throws JSONException, JsonParseException, JsonMappingException, IOException {
		List<Data> customers = dao.isData();
		
		String json = customers.get(0).getJSON_VALUE();
		
		ObjectMapper mapper = new ObjectMapper();
		JSONObject jsonObj = new JSONObject(json);
		LoanData loanData = mapper.readValue(jsonObj.toString(),LoanData.class);
		
		return loanData;
		
		
	}

}
