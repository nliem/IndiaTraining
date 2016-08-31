package taxi;

import java.util.Collection;

import org.apache.log4j.Logger;

import interfaces.Manager;
import utils.GlobalLogger;

public class TaxiManager implements Manager<Taxi> {
	
	private static TaxiManager instance;
	private TaxiDao dao;
	private Logger log = GlobalLogger.getLogger();
	
	private TaxiManager(){
		this.dao = new TaxiDao();
	}
	
	public static TaxiManager getInstance(){
		if(instance == null){
			instance = new TaxiManager();
		}
		return instance;
	}

	@Override
	public boolean add(Taxi newEntry) {
		if(newEntry == null){
			log.warn("TaxiManager.add() was passed a null value to add.");
			return false;
		}
		
		int rowAdded = dao.add(newEntry);
		
		switch(rowAdded){
		  case 1:
	        log.info("The Taxi entry was added.");
	        return true;
	      case 0:
	        log.info("The Taxi entry was not added.");
	        return false;
	      default:
	        log.fatal("ERROR! TaxiManager.add(" + newEntry + ").");
	        return false;
		}
	}

	@Override
	public boolean remove(String identifier) {
		if (identifier == null) {
	      log.warn("TaxiManager.remove() was given a null identifier value.");
	      return false;
	    }

	    int rowRemoved = dao.remove(identifier);

	    switch (rowRemoved) {
	      case 1:
	        log.info("The Taxi entry was removed.");
	        return true;
	      case 0:
	        log.info("The Taxi entry was not removed.");
	        return false;
	      default:
	        log.fatal("ERROR! TaxiManager.remove(" + identifier + ")");
	        return false;
	    }
	}

	@Override
	public String showInformation(String identifier) {
		if (identifier == null) {
	      log.warn("TaxiManager.showInformation() was given a null identifier value.");
	      return null;
	    }

	    Taxi taxi = dao.findEntry(identifier);

	    if (taxi == null) {
	      return null;
	    }

	    return taxi.toString();
	}

	@Override
	public Taxi findEntry(String identifier) {
		if (identifier == null) {
	      log.warn("TaxiUserManager.findEntry() was given a null identifier value.");
	      return null;
	    }

	    Taxi taxi = dao.findEntry(identifier);

	    return taxi;
	}
	
	public Collection<Taxi> findLocationTaxis(String location){
		if (location == null) {
			log.warn("TaxiManager.findLocationTaxis() was given a null identifier value.");
			return null;
		}
		
		Collection<Taxi> taxis = dao.findLocationTaxis(location);
		
		return taxis;
	}

}
