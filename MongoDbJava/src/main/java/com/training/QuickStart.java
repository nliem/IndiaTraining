package com.training;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class QuickStart {
	
	public static void main(String[] args){
		
		MongoClient mongo;
		try {
			mongo = new MongoClient("localhost", 27017);
			
			DB db = mongo.getDB("test");
			
			DBCollection collection = db.getCollection("myusers");
			
			BasicDBObject obj = new BasicDBObject();
			
			obj.put("userId", "Ramesh");
			
			DBCursor cursor = collection.find(obj);
			
			System.out.println(cursor.count());
			
			while(cursor.hasNext()){
				System.out.println(cursor.next());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
	}

}
