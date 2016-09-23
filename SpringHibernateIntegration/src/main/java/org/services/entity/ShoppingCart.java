package org.services.entity;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

	private int cartId;
	private String item;
	
	public ShoppingCart(){
		super();
	}
	
	public ShoppingCart(int cartId, String item){
		this.cartId = cartId;
		this.item = item;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Cart Number:\t" + cartId + "\n");
		sb.append("Cart Item:\t" + item + "\n");
		return sb.toString();
	}
}
