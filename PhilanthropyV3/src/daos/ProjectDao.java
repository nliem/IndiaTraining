package daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import exceptions.InvalidAmountException;
import exceptions.NullValueException;
import interfaces.Dao;
import project.Project;
import utilities.MySQLConnection;

public class ProjectDao implements Dao<Project>{
	
	private Connection con = null;
	
	private ProjectDao(){
		super();
		this.con = MySQLConnection.getMyOracleConnection();
	}

	@Override
	public int add(Project item) {
		int result = 0;
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL ADD_PROJECT(?,?,?,?,?,?)}");
			cstatement.setInt(1, item.getProjectId());
			cstatement.setString(2, item.getProjectName());
			cstatement.setString(3, item.getProjectDescription());
			cstatement.setDouble(4, item.getProjectCollectedAmount());
			cstatement.setDouble(5, item.getProjectCollectedAmount());
			cstatement.registerOutParameter(6, java.sql.Types.NUMERIC);
			
			cstatement.execute();
			result = cstatement.getInt(6);
			return result;
		}
		catch(SQLException e){
			System.out.println("Error calling ADD_PROJECT with project " + item);
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Project get(int id) {
		Project project = null;
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL FIND_PROJECT(?,?)}");
			cstatement.setInt(1, id);
			cstatement.registerOutParameter(2, java.sql.Types.REF_CURSOR);
			cstatement.execute();
			
			ResultSet results = cstatement.getArray(2).getResultSet();
			if(!results.first()){
				System.out.println("No Project found with id " + id);
				return project;
			}
			
			project = new Project(results.getInt(1), results.getString(2), results.getString(3), results.getDouble(4),results.getDouble(5));
		}
		catch(SQLException | NullValueException | InvalidAmountException e){
			System.out.println("Error calling FIND_PROJECT with id " + id);
			e.printStackTrace();
		}
		
		return project;
	}

	@Override
	public Collection<Project> getAll() {
		ArrayList<Project> projectList = new ArrayList<>();
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL FIND_ALL_PROJECTS(?)}");
			cstatement.registerOutParameter(1, java.sql.Types.REF_CURSOR);
			cstatement.execute();
			ResultSet results = cstatement.getArray(1).getResultSet();
			
			while(results.next()){
				Project project = new Project(results.getInt(1), results.getString(2), results.getString(3), results.getDouble(4),results.getDouble(5));
				projectList.add(project);
			}
		}
		catch(SQLException | NullValueException | InvalidAmountException e){
			System.out.println("Error calling FIND_ALL_PROJECTS.");
			e.printStackTrace();
		}
		return projectList;
	}

	@Override
	public int remove(int id) {
		int result = 0;
		
		try{
			CallableStatement cstatement = con.prepareCall("{CALL REMOVE_PROJECT(?,?)}");
			cstatement.setInt(1, id);
			cstatement.registerOutParameter(2, java.sql.Types.NUMERIC);
			
			cstatement.execute();
			result = cstatement.getInt(2);
		}
		catch(SQLException e){
			System.out.println("Error calling REMOVE_PROJECT with id " + id);
			e.printStackTrace();
		}
		
		return result;
	}

}
