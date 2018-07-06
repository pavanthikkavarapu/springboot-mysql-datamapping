package com.example.basicapp.dao;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.stereotype.Repository;
	import org.json.simple.JSONObject;

import com.example.basicapp.model.Data;
import com.example.basicapp.model.JsonObject;
import com.google.gson.Gson;

	@Repository
	public class SpringDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String SQL = "select * from ent_loan";
	public List<Data> isData() {
	List<Data> datas = new ArrayList<Data>();
	List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);
	for (Map<String, Object> row : rows) 
	{
	Data data = new Data();
		
		 data.setID((int)row.get("ID"));
		 data.setVERSION((int)row.get("VERSION"));
		 data.setCREATED_BY((String)row.get("CREATED_BY"));
		 data.setMODIFIED_BY((String)row.get("MODIFIED"));
		 //data.setMODIFIED_DATE((String)row.get("MODIFIED_DATE"));
		 data.setLoanId((int)row.get("LoanId"));
		 data.setBapId((String)row.get("bapID"));
		 data.setLoanNumber((String)row.get("loanNumber"));
		 data.setProviderTenantId((String)row.get("providerTenantId"));
		 data.setClientTenantId((String)row.get("clientTenantId"));
		 data.setJSON_VALUE((String)row.get("JSON_VALUE"));
		datas.add(data);

		// from JSON to object 
		//datas o = gson.fromJson(JSONString,datas.class)
	}
//	List<String> jsonString = rows.entrySet().stream().filter((jsonValue) -> jsonValue.getKey("JSON_VALUE")).collect(Collectors.toList());
/*	List<String> jsonString = rows.stream().filter((jsonValue) -> jsonValue.("JSON_VALUE")).collect(Collectors.toList());
	List<JsonObject> JsonObject = jsonString.stream().map((jsonSring) -> new JsonObject(jsonSring)).collet(Collectors.toList());*/	
	System.out.println(datas.size());
	
	return datas;
	}
	}

