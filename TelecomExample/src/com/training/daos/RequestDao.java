package com.training.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.training.entity.Request;
import com.training.interfaces.Dao;

@Component("requestDao")
public class RequestDao implements Dao<Request>{

	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private BeanPropertyRowMapper<Request> mapper;
	
	public List<Request> findType(String type){
		String sql = "SELECT * FROM REQUEST WHERE REQUESTTYPE = ?";
		
		List<Request> customerList = template.query(sql, mapper, type.toUpperCase());
		
		return customerList;
	}

	@Override
	public int add(Request object) {
		String sql = "INSERT INTO REQUEST VALUES(?,?,?,?)";
		
		int rowsInserted = template.update(sql, object.getRequestId(), object.getCustomerId(), 
				object.getRequestType().toUpperCase(), object.getDescription());
		
		return rowsInserted;
	}

	@Override
	public Request find(int key) {
		String sql = "SELECT * FROM REQUEST WHERE REQUESTID = ?";
		
		Request request = template.queryForObject(sql, mapper, key);
		
		return request;
	}

	@Override
	public List<Request> findAll() {
		String sql = "SELECT * FROM REQUEST";
		
		List<Request> requestList = template.query(sql, mapper);
		
		return requestList;
	}
	
	
}
