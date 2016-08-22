package donor;

import java.util.Collection;

import daos.DonorDao;
import exceptions.NullValueException;
import interfaces.Manager;

public class DonorManager implements Manager<Donor> {
	
	private static DonorManager instance;
	private DonorDao dao;
	
	private DonorManager(){
		this.dao = new DonorDao();
	}
	
	public static DonorManager getInstance(){
		if(instance == null){
			instance = new DonorManager();
		}
		return instance;
	}

	@Override
	public void add(Donor newValue) throws NullValueException {
		int rowAdded = dao.add(newValue);
		
		switch(rowAdded){
		case 0:
			System.out.println("Donor was not added.");
			break;
		case 1:
			System.out.println("Donor was inserted into table.");
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
			System.out.println("Donor was not removed.");
			break;
		case 1:
			System.out.println("Donor was removed.");
			break;
		default:
			System.out.println("YOU GOT PROBLEMS!!!");
			break;
		}
		
	}

	@Override
	public String displayInformation(int identification) {
		Donor result = dao.get(identification);
		if(result == null) return "FAILED";
		
		return result.toString();
	}

	@Override
	public String displayAllData() {
		Collection<Donor> donors = dao.getAll();
		
		StringBuilder sb = new StringBuilder();
		for(Donor d : donors){
			sb.append(d.toString()).append("\n");
		}
		return sb.toString();
	}

}
