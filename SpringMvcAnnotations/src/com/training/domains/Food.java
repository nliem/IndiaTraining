package com.training.domains;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

import java.text.DecimalFormat;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.stereotype.Component;

@Component("food")
public class Food {
	
	@Min(value=1)
	@Max(value=1000)
	@NotNull
	@NumberFormat(style=Style.NUMBER)
	private int foodCode;
	
	@NotEmpty(message = "Description must not be blank!")
	private String description;
	
	private double price;
	
	private String cuisine;
	
	public Food(){
		super();
	}
	
	public int getFoodCode() {
		return foodCode;
	}

	public void setFoodCode(int foodCode) {
		this.foodCode = foodCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	@Override
	public String toString(){
		DecimalFormat df = new DecimalFormat("#.00");
		return "Food Code:\t" + foodCode + "<br/>Description:\t" + description + "<br/>Cost:\t$" + df.format(price) + "<br/>"
				+ "Cuisine:\t" + cuisine + "<br/>";
	}

}
