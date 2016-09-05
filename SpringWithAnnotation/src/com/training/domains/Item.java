package com.training.domains;

import java.text.DecimalFormat;

public class Item {
	
	private int itemId;
	private String itemName;
	private double ratePerUnit;
	
	public Item(int itemId, String itemName, double ratePerUnit){
		this.itemId = itemId;
		this.itemName = itemName;
		this.ratePerUnit = ratePerUnit;
	}
	
	@Override
	public String toString(){
		DecimalFormat df = new DecimalFormat("#.00");
		
		return "[" + itemName + "\t#" + itemId + "\t$" + df.format(ratePerUnit) + "]";
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getRatePerUnit() {
		return ratePerUnit;
	}

	public void setRatePerUnit(double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}

}
