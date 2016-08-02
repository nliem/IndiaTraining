package donor;

import java.util.HashMap;

import exceptions.UnknownIdException;
import interfaces.Manager;

public class DonorManager implements Manager<Donor> {
	
	private HashMap<Integer, Donor> donorList;

	@Override
	public void add(Donor newvalue) {
		donorList.put(newvalue.getDonorId(), newvalue);	
	}

	@Override
	public void remove(int identification) throws UnknownIdException {
		if(!donorList.containsKey(identification)){
			throw new UnknownIdException("No Donor found with id " + identification);
		}
	}

	@Override
	public String displayInformation(int identification) throws UnknownIdException {
		Donor donor = donorList.get(identification);
		if(donor == null){
			throw new UnknownIdException("No Donor found with id " + identification);
		}
		return donor.toString();	
	}

	@Override
	public String displayAllData() {
		StringBuilder sb = new StringBuilder();
		for(int key : donorList.keySet()){
			sb.append(donorList.get(key).toString()).append("\n");
		}
		
		return sb.toString();
	}

}
