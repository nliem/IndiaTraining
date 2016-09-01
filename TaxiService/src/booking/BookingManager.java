package booking;

import org.apache.log4j.Logger;

import interfaces.Manager;
import utils.GlobalLogger;

public class BookingManager implements Manager<Booking> {
	
	private static BookingManager instance;
	private BookingDao dao;
	private Logger log = GlobalLogger.getLogger();
	
	private BookingManager(){
		this.dao = new BookingDao();
	}
	
	public static BookingManager getInstance(){
		if(instance == null){
			instance = new BookingManager();
		}
		return instance;
	}

	@Override
	public boolean add(Booking newEntry) {
		if(newEntry == null){
			log.warn("BookingManager.add() was passed a null value to add.");
			return false;
		}
		
		int rowAdded = dao.add(newEntry);
		
		switch(rowAdded){
		  case 1:
	        log.info("The Booking entry was added.");
	        return true;
	      case 0:
	        log.info("The Booking entry was not added.");
	        return false;
	      default:
	        log.fatal("ERROR! TaxiManager.add(" + newEntry + ").");
	        return false;
		}
	}

	@Override
	public boolean remove(String identifier) {
		if (identifier == null) {
	      log.warn("BookingManager.remove() was given a null identifier value.");
	      return false;
	    }

	    int rowRemoved = dao.remove(identifier);

	    switch (rowRemoved) {
	      case 1:
	        log.info("The Booking entry was removed.");
	        return true;
	      case 0:
	        log.info("The Booking entry was not removed.");
	        return false;
	      default:
	        log.fatal("ERROR! TaxiManager.remove(" + identifier + ")");
	        return false;
	    }
	}

	@Override
	public String showInformation(String identifier) {
		if (identifier == null) {
	      log.warn("BookingManager.showInformation() was given a null identifier value.");
	      return null;
	    }

	    Booking booking = dao.findEntry(identifier);

	    if (booking == null) {
	      return null;
	    }

	    return booking.toString();
	}

	@Override
	public Booking findEntry(String identifier) {
		if (identifier == null) {
	      log.warn("TaxiUserManager.findEntry() was given a null identifier value.");
	      return null;
	    }

	    Booking booking = dao.findEntry(identifier);

	    return booking;
	}

}
