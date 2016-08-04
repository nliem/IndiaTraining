package classes;

import java.sql.Connection;

public class MyDoaImpl {
	
	Connection con;
	
	public MyDoaImpl(Connection con){
		if(con == null){
			throw new NullPointerException("Oh shit, null connection...");
		}
		this.con = con;
	}
	
	public MyDoaImpl(){
		super();
	}

}
