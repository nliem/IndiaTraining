package com.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
	
	@Value("101")
	private long bookNumber;
	
	@Value("The Old Man and the Sea")
	private String bookName;
	
	public Book(){
		super();
	}

	public long getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(long bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	@Override
	public String toString(){
		return "Book Number:\t" + bookNumber + "\nBook Name:\t" + bookName + "\n";
	}

}
