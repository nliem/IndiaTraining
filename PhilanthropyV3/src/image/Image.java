package image;

import exceptions.NullValueException;

public class Image {
	
	private int image_id;
	private int project_id;
	private String image_path;
	private String image_name;
	private String image_caption;
	
	public Image(int i_id, int p_id, String i_path, String i_name, String i_caption)
		throws NullValueException{
		if(i_path == null){
			throw new NullValueException("Image path cannot be null."); 
		}
		if(i_name == null){
			throw new NullValueException("Image name cannot be null.");
		}
		
		image_id = i_id;
		project_id = p_id;
		image_path = i_path;
		image_name = i_name;
		image_caption = i_caption;
	}
	
	public Image(int p_id, String i_path, String i_name, String i_caption)
		throws NullValueException{
		this(0, p_id, i_path, i_name, i_caption);
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
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Image #: " + image_id).append("\n");
		sb.append("Image path: " + image_path).append("\n");
		sb.append("Image name: " + image_name).append("\n");
		sb.append(image_caption).append("\n\n");
		
		return sb.toString();
	}

}
