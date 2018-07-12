package com.example.basicapp.dao;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.basicapp.model.CoverPage;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class SpringDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate; 

	public String getMlcReportDetails(String loanNumber) {
		
		String SQL = " select JSON_VALUE from ent_loan where loanNumber = \"" + loanNumber + "\" limit 1";
		String JsonValue = jdbcTemplate.queryForObject(SQL, String.class);
		
		return JsonValue;
	}
	
	public CoverPage getCoverPage(int poolInstanceId) throws JSONException, JsonParseException, JsonMappingException, IOException {
		
		String SQL = " select JSON_VALUE from ent_order where poolInstanceId ="+ poolInstanceId;
		List<String> JsonValue = jdbcTemplate.queryForList(SQL, String.class);
		String json = JsonValue.get(0);
		ObjectMapper mapper = new ObjectMapper();
		JSONObject jsonObj = new JSONObject(json);
		CoverPage coverPageData = mapper.readValue(jsonObj.toString(), CoverPage.class);
		if (coverPageData.getLoanCountAll() != 0) {
			coverPageData.setSamplingPercent((coverPageData.getLoanCountAudited() / coverPageData.getLoanCountAll()) * 100);
		}
		return coverPageData;
	}
}

