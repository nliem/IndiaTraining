package daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import exceptions.NullValueException;
import image.Image;
import interfaces.Dao;
import utilities.MySQLConnection;

public class ImageDao implements Dao<Image>{
	
	private Connection con = null;
	
	public ImageDao(){
		super();
		this.con = MySQLConnection.getMyOracleConnection();
	}

	@Override
	public int add(Image item) {
		int result = 0;
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL ADD_IMAGE(?,?,?,?,?,?)}");
			cstatement.setInt(1, item.getImageId());
			cstatement.setInt(2, item.getProjectId());
			cstatement.setString(3, item.getImagePath());
			cstatement.setString(4, item.getImageName());
			cstatement.setString(5, item.getImageCaption());
			cstatement.registerOutParameter(6, java.sql.Types.REF_CURSOR);
			
			cstatement.execute();
			result = cstatement.getInt(6);
			return result;
		}
		catch(SQLException e){
			System.out.println("Error calling ADD_IMAGE with image " + item.toString());
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Image get(int id) {
		Image image = null;
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL FIND_IMAGE(?,?)}");
			cstatement.setInt(1, id);
			cstatement.registerOutParameter(2, java.sql.Types.REF_CURSOR);
			
			cstatement.execute();
			ResultSet results = cstatement.getArray(2).getResultSet();
			
			if(!results.first()){
				System.out.println("No Image foudn with id " + id);
				return null;
			}
			
			image = new Image(results.getInt(1), results.getInt(2), results.getString(3), results.getString(4), results.getString(5));
			return image;
		}
		catch(SQLException | NullValueException e){
			System.out.println("Error calling FIND_IMAGE on id " + id);
			e.printStackTrace();
		}
		
		return image;
	}

	@Override
	public Collection<Image> getAll() {
		ArrayList<Image> imageList = new ArrayList<>();
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL FIND_ALL_IMAGES(?)}");
			cstatement.registerOutParameter(1, java.sql.Types.REF_CURSOR);
			cstatement.execute();
			ResultSet results = cstatement.getArray(1).getResultSet();
			
			while(results.next()){
				Image image = new Image(results.getInt(1), results.getInt(2), results.getString(3), results.getString(4), results.getString(5));
				imageList.add(image);
			}
			return imageList;
		}
		catch(SQLException | NullValueException e){
			System.out.println("Error calling FIND_ALL_IMAGES.");
			e.printStackTrace();
		}
		
		return imageList;
	}

	@Override
	public int remove(int id) {
		int result = 0;
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL REMOVE_IMAGE(?,?)}");
			cstatement.setInt(1, id);
			cstatement.registerOutParameter(2, java.sql.Types.NUMERIC);
			
			cstatement.execute();
			result = cstatement.getInt(2);
			return result;
		}
		catch(SQLException e){
			System.out.println("Error calling REMOVE_IMAGE with id " + id);
			e.printStackTrace();
		}
		
		return result;
	}

}
