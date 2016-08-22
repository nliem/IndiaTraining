package donation;

import java.util.Collection;

import daos.DonationDao;
import exceptions.NullValueException;
import interfaces.Manager;

public class DonationManager implements Manager<Donation> {
	
	private static DonationManager instance;
	private DonationDao dao;
	
	private DonationManager(){
		this.dao = new DonationDao();
	}
	
	public static DonationManager getInstance(){
		if(instance == null){
			instance = new DonationManager();
		}
		return instance;
	}

	@Override
	public void add(Donation newValue) throws NullValueException {
		int rowAdded = dao.add(newValue);
		
		switch(rowAdded){
		case 0:
			System.out.println("Donation was not added.");
			break;
		case 1:
			System.out.println("Donation was inserted into table.");
			break;
		default:
			System.out.println("YOU GOT PROBLEMS!!!");
			break;
		}
		
	}

	@Override
	public void remove(int identification) {
		int rowRemoved = dao.remove(identification);
		
		switch(rowRemoved){
		case 0:
			System.out.println("Donation was not removed.");
			break;
		case 1:
			System.out.println("Donation was removed.");
			break;
		default:
			System.out.println("YOU GOT PROBLEMS!!!");
			break;
		}
		
	}

	@Override
	public String displayInformation(int identification) {
		Donation result = dao.get(identification);
		
		return result.toString();
	}

	@Override
	public String displayAllData() {
		Collection<Donation> donations = dao.getAll();
		
		StringBuilder sb = new StringBuilder();
		for(Donation d : donations){
			sb.append(d.toString()).append("\n");
		}
		
		return sb.toString();
	}

}
