package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import exceptions.InvalidAmountException;
import exceptions.NullValueException;
import interfaces.Dao;
import project.Project;
import utilities.MySQLConnection;

public class ProjectDao implements Dao<Project> {
	
	private Connection con = null;
	
	public ProjectDao(){
		super();
		this.con = MySQLConnection.getMyOracleConnection();
	}
	
	public ProjectDao(Connection c) throws NullValueException{
		super();
		if(c == null){
			//should I also log this? TODO
			throw new NullValueException("Connection passed to Dao constructor cannot be null.");
		}
		this.con = c;
	}

	@Override
	public int add(Project item) {
		// TODO make this a stored procedure :( 
		return 0;
	}

	@Override
	public Project get(int id) {
		String sqlSelectStatement = "SELECT * FROM PROJECTS WHERE PROJECT_ID = ?";
		Project project = null;
		
		try{
			PreparedStatement pstatement = this.con.prepareStatement(sqlSelectStatement);
			pstatement.setInt(1, id);
			
			ResultSet results = pstatement.executeQuery();
			
			//TODO check if this next line actually works...
			
			if(!results.first()){
				//throw an exception here?
			}
			
			project = new Project(results.getInt(1), results.getString(2), results.getString(3), results.getDouble(4));
			return project;
		}
		catch(SQLException | NullValueException | InvalidAmountException e){
			//TODO log here? specific actions for each exception?
			System.out.println("Error occured while trying to find project with id " + id);
			e.printStackTrace();
		}
		
		return project;
	}

	@Override
	public Collection<Project> getAll() {
		ArrayList<Project> projectList = new ArrayList<>();
		String sqlSelectStatement = "SELECT * FROM PROJECTS";
		
		try{
			PreparedStatement pstatement = this.con.prepareStatement(sqlSelectStatement);
			ResultSet results = pstatement.executeQuery();
			
			while(results.next()){
				Project p = new Project(results.getInt(1), results.getString(2), results.getString(3), results.getDouble(4));
				projectList.add(p);
			}
		}
		catch(SQLException | NullValueException | InvalidAmountException e){
			//TODO log here? specific actions for each exception?
			System.out.println("Error occured while executing statement: " + sqlSelectStatement);
			e.printStackTrace();
		}
		
		return projectList;
	}

	@Override
	public int remove(int id) {
		// TODO make this a stored procedure :(
		return 0;
	}

}
