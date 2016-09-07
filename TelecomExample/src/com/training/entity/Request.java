package com.training.entity;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.stereotype.Component;
import javax.validation.constraints.*;

@Component("request")
public class Request {

	@NotNull
	@Min(value=1)
	@Max(value=100)
	@NumberFormat(style=Style.NUMBER)
	private int requestId;
	
	@NotNull
	@Min(value=1)
	@Max(value=100)
	@NumberFormat(style=Style.NUMBER)
	private int customerId;
	
	@NotNull
	private String requestType;
	
	private String description;
	
	public Request(){
		super();
	}
	
	public Request(String requestType, String description, int requestId, int customerId){
		this.requestType = requestType;
		this.description = description;
		this.requestId = requestId;
		this.customerId = customerId;
	}
	
	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString(){
		return "<hr/>Request ID: " + requestId + "<br/>Customer ID: " + customerId + 
				"<br/>Request Type: " + requestType + "<br/>Description:<br/>" +
				description +"<br/><hr/>";
	}
	
}
