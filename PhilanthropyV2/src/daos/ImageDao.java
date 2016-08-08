package daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public ImageDao(Connection c) throws NullValueException{
		super();
		if(c == null){
			//TODO should I also log this?
			throw new NullValueException("Connection passed to Dao constructor cannot be null.");	
		}
		this.con = c;
	}

	@Override
	public int add(Image item) {
		int result = 0;
		
		try{
			CallableStatement cstatement = this.con.prepareCall("{CALL ADD_IMAGE(?,?,?,?,?)}");
			
			cstatement.setInt(1, item.getProjectId());
			cstatement.setString(2, item.getImagePath());
			cstatement.setString(3, item.getImageName());
			cstatement.setString(4, item.getImageCaption());
			cstatement.registerOutParameter(5, java.sql.Types.NUMERIC);
			
			cstatement.execute();
			result = cstatement.getInt(5);
		}
		catch(SQLException e){
			//TODO log here?
			System.out.println("Error occurred adding donor: " + item.toString());
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Image get(int id) {
		Image image = null;
		
		//TODO really need to consider if this is necessary/workable
		String sqlSelectStatement = "SELECT * FROM IMAGES WHERE IMAGE_ID = ?";
		
		try{
			PreparedStatement pstatement = this.con.prepareStatement(sqlSelectStatement);
			pstatement.setInt(1, id);
			
			ResultSet results = pstatement.executeQuery();
			
			//TODO check if this next line actually works...
			if(!results.first()){
				//throw an exception here? 
			}
			
			image = new Image(results.getInt(1), results.getInt(2), results.getString(3),
					results.getString(4), results.getString(5));
			return image;
		}
		catch(SQLException | NullValueException e){
			//TODO log here? specific actions for each exception?
			System.out.println("Error occured while executing statement: " + sqlSelectStatement);
			e.printStackTrace();
		}
		
		return image;
	}

	@Override
	public Collection<Image> getAll() {
		ArrayList<Image> imageList = new ArrayList<>();
		String sqlSelectStatement = "SELECT * FROM IMAGES";
		
		try{
			PreparedStatement pstatement = this.con.prepareStatement(sqlSelectStatement);
			ResultSet results = pstatement.executeQuery();
			
			while(results.next()){
				Image i = new Image(results.getInt(1), results.getInt(2), results.getString(3),
						results.getString(4), results.getString(5));
				imageList.add(i);
			}
		}
		catch(SQLException | NullValueException e){
			//TODO log here? specific actions for each exception?
			System.out.println("Error occured while executing statement: " + sqlSelectStatement);
			e.printStackTrace();
		}
		
		
		return imageList;
	}

	@Override
	public int remove(int id) {
		int result = 0;
		
		try{
			CallableStatement cstatement = this.con.prepareCall("{CALL REMOVE_IMAGE(?,?)}");
			
			cstatement.setInt(1, id);
			cstatement.registerOutParameter(2, java.sql.Types.NUMERIC);
			
			cstatement.execute();
			result = cstatement.getInt(2);
		}
		catch(SQLException e){
			//log here?
			//TODO 
			System.out.println("Error occured while trying to delete donor with id " + id);
			e.printStackTrace();
		}
		
		return result;
	}
	

}
