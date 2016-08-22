package image;

import java.util.Collection;

import daos.ImageDao;
import exceptions.NullValueException;
import interfaces.Manager;

public class ImageManager implements Manager<Image> {
	
	private static ImageManager instance;
	private ImageDao dao;
	
	private ImageManager(){
		this.dao = new ImageDao();
	}
	
	public static ImageManager getInstance(){
		if(instance == null){
			instance = new ImageManager();
		}
		return instance;
	}

	@Override
	public void add(Image newValue) throws NullValueException {
		int rowAdded = dao.add(newValue);
		
		switch(rowAdded){
		case 0:
			System.out.println("Image was not added.");
			break;
		case 1:
			System.out.println("Image was inserted into table.");
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
			System.out.println("Image was not removed.");
			break;
		case 1:
			System.out.println("Image was removed.");
			break;
		default:
			System.out.println("YOU GOT PROBLEMS!!!");
			break;
		}
		
	}

	@Override
	public String displayInformation(int identification) {
		Image result = dao.get(identification);
		return result.toString();
	}

	@Override
	public String displayAllData() {
		Collection<Image> images = dao.getAll();
		
		StringBuilder sb = new StringBuilder();
		for(Image i : images){
			sb.append(i.toString()).append("\n");
		}
		
		return sb.toString();
	}

}
