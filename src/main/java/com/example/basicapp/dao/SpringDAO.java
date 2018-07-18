package com.example.basicapp.dao;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.basicapp.service.AuditSummaryReportSevice;

@Repository
public class SpringDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate; 

	@Autowired
	private AuditSummaryReportSevice auditSummaryReportSevice; 

	
	public String getMlcReportDetails(String loanNumber) {
		
		
		
		String SQL = " select JSON_VALUE from ent_loan where loanNumber = \"" + loanNumber + "\" limit 1";
		String JsonValue = jdbcTemplate.queryForObject(SQL, String.class);
		
		return JsonValue;
	}
	
	/*public CoverPage getCoverPage(int poolInstanceId) throws JSONException, JsonParseException, JsonMappingException, IOException {
		
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
	}*/
	
public List<String> getOrderList(int poolInstanceId, String reportType) throws JSONException, IOException, java.io.IOException, ParseException {
		
		String SQL = " select JSON_VALUE from ent_order where poolInstanceId ="+ poolInstanceId;
		List<String> ordersList = jdbcTemplate.queryForList(SQL, String.class);
		
		return ordersList;
	}

public void getOrderConditionList(String orderId) throws JSONException, IOException, java.io.IOException, ParseException {
	
	String SqlQueryEntOrderCondition = "select JSON_VALUE from tc1_rr_write_db.ent_order_condition where orderId="+orderId;
	List<String> orderConditionList = jdbcTemplate.queryForList(SqlQueryEntOrderCondition, String.class);

	auditSummaryReportSevice.setOrderConditionList(orderConditionList);
	
	//return orderConditionList;
}


	
}

