package image;

import java.util.Collection;

import daos.ImageDao;
import exceptions.NullValueException;
import interfaces.Manager;

public class ImageManager implements Manager<Image>{
	
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
	public void add(Image newValue) throws NullValueException{
		if(newValue == null){
			throw new NullValueException("Cannot add a null Image into IMAGES table.");
		}
		
		int rowAdded = this.dao.add(newValue);
		
		//TODO change this to logging eventually...
		switch(rowAdded){
		case 0:
			System.out.println("Add attempt failed. No image was added.");
			break;
		case 1:
			System.out.println("Donor: " + newValue.toString() + "\nSuccessfully added to IMAGES.");
			break;
		default:
			System.out.println("This line should never be hit!!!");
			break;
		}
	}

	@Override
	public void remove(int identification) {
		int removedRow = dao.remove(identification);
		
		//TODO change this to logging eventually
		switch (removedRow){
		case 0:
			System.out.println("Image with id " + identification + " not found. No rows deleted.");
			break;
		case 1:
			System.out.println("Deletion of donor with id " + identification + " successful.");
			break;
		default:
			System.out.println("This line should never be hit!!!");
			break;
		}
		
	}

	@Override
	public String displayInformation(int identification) {
		Image image = this.dao.get(identification);
		
		if(image == null){
			//TODO throw an error here? does ImageDao prevent this from being returned???
		}
		
		//This line better not be executed if image is null
		return image.toString();
	}

	@Override
	public String displayAllData() {
		Collection<Image> imageList = dao.getAll();
		StringBuilder result = new StringBuilder();
		
		if(imageList.isEmpty()){
			return "No images to display.\n";
		}
		else{
			for(Image image : imageList){
				result.append(image.toString()).append("\n");
			}
		}
		
		return result.toString();
	}

}
