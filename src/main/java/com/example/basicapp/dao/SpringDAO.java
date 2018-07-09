package com.example.basicapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpringDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate; 

	public String isData(String loanNumber) {
		
		String SQL = " select JSON_VALUE from ent_loan where loanNumber = \"" + loanNumber + "\" limit 1";
		String JsonValue = jdbcTemplate.queryForObject(SQL, String.class);
		
		return JsonValue;
	}
}

