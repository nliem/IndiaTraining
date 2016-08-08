package image;

import exceptions.NullValueException;

public class Image {
	
	private int image_id;
	private int project_id;
	private String image_path;
	private String image_name;
	private String image_caption;
	
	//constructor to be called when an Image created from a db call
	public Image(int imageId, int projectId, String path, String name, String caption)
	  throws NullValueException{
		//TODO should I also be logging here
		if(path == null){
			throw new NullValueException("Image path cannot be null.");
		}
		if(name == null){
			throw new NullValueException("Image name cannot be null.");
		}
		//should caption also be non-null? nah?
		
		this.image_id = imageId;
		this.project_id = projectId;
		this.image_path = path;
		this.image_name = name;
		this.image_caption = caption;
		
	}
	
	//constructor to be called when an Image is created by user
	public Image(int pId, String path, String name, String caption)
	  throws NullValueException{
		//TODO should I also be logging here?
		if(path == null){
			throw new NullValueException("Image path cannot be null.");
		}
		if(name == null){
			throw new NullValueException("Image name cannot be null.");
		}
		//should caption also be non-null? nah? 
		
		this.project_id = pId;
		this.image_path = path;
		this.image_name = name;
		this.image_caption = caption;
	}
	
	@Override 
	public String toString(){
		//TODO DO THISSSSSS
		return null;
	}
	
	public int getImageId(){
		return this.image_id;
	}
	
	public int getProjectId(){
		return this.project_id;
	}

	public String getImagePath(){
		return this.image_path;
	}
	
	public String getImageName(){
		return this.image_name;
	}
	
	public String getImageCaption(){
		return this.image_caption;
	}

}
