package com.training.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.training.entity.Customer;
import com.training.interfaces.MyDao;

@Component("customerDao")
public class CustomerDao implements MyDao<Customer> {
	
	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private BeanPropertyRowMapper<Customer> mapper;
	
	@Override
	public int add(Customer object){
		String sql = "INSERT INTO CUSTOMER VALUES(?, ?, ?, ?)";
		
		int rowsInserted = template.update(sql, object.getCustomerNumber(), object.getCustomerName(), object.getEmail(), object.getPhoneNumber());
		
		return rowsInserted;
	}
	
	@Override
	public Customer find(long key){
		String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMERNUMBER = ?";
		
		Customer customer = template.queryForObject(sql, mapper, key);
		
		return customer;
	}
	
	@Override
	public List<Customer> findAll(){
		String sql = "SELECT * FROM CUSTOMER";
		
		List<Customer> customerList = template.query(sql, mapper);
		
		return customerList;
	}
}
