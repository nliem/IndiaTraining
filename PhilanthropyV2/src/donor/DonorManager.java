package donor;

import java.util.Collection;

import daos.DonorDao;
import interfaces.Manager;

public class DonorManager implements Manager<Donor> {
	
	private static DonorManager instance;
	private DonorDao dao;
	
	private DonorManager(){
		//set up DonorDao instance
		this.dao = new DonorDao();
	}
	
	public static DonorManager getInstance(){
		if(instance == null){
			instance = new DonorManager();
		}
		return instance;
	}

	@Override
	public void add(Donor newValue) {
		if(newValue == null){
			//should I throw an exception here?
			//TODO
		}
		dao.add(newValue);
	}

	@Override
	public void remove(int identification) {
		int removedRow = dao.remove(identification);
		
		//change this to logging eventually!!!!
		//TODO
		switch(removedRow){
		case 1: 
			System.out.println("Deletion of donor with id " + identification + " successful.");
			break;
		case 0:
			System.out.println("Donor with id " + identification + " not found. No rows deleted.");
			break;
		default:
			System.out.println("This line should never be hit!");
			break;
		}
	}

	@Override
	public String displayInformation(int identification) {
		Donor donor = dao.get(identification);
		
		if(donor == null){
			//is this redundant? isn't this check done in the DonorDao???
			//log? throw an exception?
			//TODO
		}
		
		//THIS LINE SHOULDN'T BE EXECUTED IF DONOR IS NULLLLLL PLS NO NULL POINTER EXCEPTIONS
		return donor.toString();
	}

	@Override
	public String displayAllData() {
		Collection<Donor> donorList = dao.getAll();
		StringBuilder result = new StringBuilder();
		
		if(donorList.isEmpty()){
			return "No donors to display.\n";
		}
		
		else{
			for(Donor donor : donorList){
				result.append(donor.toString()).append("\n");
			}
		}
		
		return result.toString();
	}

}
