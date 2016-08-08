package image;

import daos.ImageDao;
import interfaces.Manager;

public class ImageManager implements Manager<Image>{
	
	private static ImageManager instance;
	private ImageDao dao;
	
	private ImageManager(){
		this.dao = new ImageDao();
	}
	
	

	@Override
	public void add(Image newValue) {
		// TODO Auto-generated method stub
		
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
