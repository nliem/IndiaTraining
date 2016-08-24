package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class StatusFinder {
	
	private HashMap<Long, List<PaymentStatus>> payments;
	
	
	public StatusFinder(){
		payments = new HashMap<>();
	}
	
	public void initialize(){
		ArrayList<PaymentStatus> list = new ArrayList<>();
		long phoneNumber = 4295726;
		PaymentStatus status1 = new PaymentStatus(1, parseDate("2016-06-05"), "Natalie Payment 1.", 50.00);
		PaymentStatus status2 = new PaymentStatus(11, parseDate("2016-10-21"), "Natalie Payment 2.", 500.00);
		
		list.add(status1);
		list.add(status2);
		
		payments.put(phoneNumber, list);
		
		/*
		phoneNumber = 2181370;
		status = new PaymentStatus(2, parseDate("1995-12-20"), "Alyssa Payment.", 60.00);
		payments.put(phoneNumber, status);
		
		phoneNumber = 3840540;
		status = new PaymentStatus(3, parseDate("1963-12-27"), "Norine Payment", 100.00);
		payments.put(phoneNumber, status);
		*/
	}
	
	public List<PaymentStatus> getPaymentStatus(long number){
		return payments.get(number);
	}
	
	private Date parseDate(String date){
		try{
			return new SimpleDateFormat("yyy-MM-dd").parse(date);
		}catch(ParseException e){
			return null;
		}
	}
	

}
