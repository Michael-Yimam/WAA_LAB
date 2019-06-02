package edu.mum.dao;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;

//@SuppressWarnings("deprecation")
public class MongoFactory2 {

    private static MongoClient mongo;

    private MongoFactory2(){}

    // Returns a mongo instance
    public static MongoClient getMongo(){
        int port_no = 27017;
        String hostname = "localhost";

        if(mongo == null){
            try{
                mongo = new MongoClient(hostname, port_no);
            }catch(MongoException ex){
                System.out.println("MongoException happened. - " + ex);
            }
        }
        return mongo;
    }

    // Fetches the mongo database.
    public static MongoDatabase getDB(String db_name){
        return getMongo().getDatabase(db_name);
    }
}
