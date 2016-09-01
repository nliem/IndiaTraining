package resources;

import java.util.HashMap;

import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.owlike.genson.Genson;

import other.Cat;
import other.Invoice;

@Path("/simple")
public class SimpleResource {
	
	private HashMap<Integer, String> map;
	
	/*
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(){
		return "You have configured Jersey properly!";
	}
	*/
	
	@Path("/inv")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getInfo(){
		Invoice inv = new Invoice(101, "Ramesh", 4500);
		Cat cat = new Cat("Kitty", 10);
		
		//serializes into json object
		Genson serializer = new Genson();
		String resp = serializer.serialize(cat);
		System.out.println(inv);
		System.out.println(resp);
		return resp;
	}
	
	@GET
	@Path("/find/{userId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String findUser(@PathParam("userId") int id){
		System.out.println("FINDUSER() CALLED"); 
		initialize();
		return map.get(id);
	}
	
	@Path("/delete")
	@DELETE
	public String removeUser(@QueryParam("userId") int id){
		initialize();
		System.out.println("REMOVEUSER() CALLED");
		return map.remove(id);
	}
	
	@Path("/add")
	@POST
	public String addUser (@FormParam("userId") int id, @FormParam("name") String name){
		initialize();
		map.put(id, name);
		return map.toString();
	}
	
	private void initialize(){
		System.out.println("INITIALIZE()!!");
		map = new HashMap<>();
		map.put(1, "Natalie");
		map.put(2, "Sonny");
	}

}
