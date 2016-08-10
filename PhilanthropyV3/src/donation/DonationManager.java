package donation;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public String displayInformation(int identification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String displayAllData() {
		// TODO Auto-generated method stub
		return null;
	}

}
