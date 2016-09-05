package com.training.domains;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Invoice {
	
	private long invoiceNumber;
	private Customer customer;
	private double amount;
	private List<Item> itemList;
	
	public Invoice(){
		super();
	}
	
	@Override
	public String toString(){
		DecimalFormat df = new DecimalFormat("#.00");
		StringBuilder sb = new StringBuilder();
		
		sb.append("Invoice Number:\t#" + invoiceNumber).append("\n");
		sb.append("Customer:\n\n" + customer).append("\n");
		sb.append("Invoice amount:\t$" + df.format(amount)).append("\n");
		sb.append("Items:\n" + itemList);
		
		return sb.toString();
	}
	
	//@PostConstruct
	public void init(){
		System.out.println("Setting up!");
	}
	
	//@PreDestroy
	public void cleanUp(){
		System.out.println("Cleaning up!");
	}

	public long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

}
