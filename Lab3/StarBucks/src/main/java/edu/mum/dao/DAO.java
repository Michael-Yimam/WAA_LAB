package edu.mum.dao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.*;
import edu.mum.dao.MongoFactory;
import edu.mum.domain.Coffee;
import edu.mum.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DAO {

    private String db_name;
    private String db_collection;

    // Fetch all users from the mongo database.
    public List getAll(){
        List user_list = new ArrayList();
        DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

        // Fetching cursor objet fro iterating on the database records.
        DBCursor cursor = coll.find();
        while(cursor.hasNext()){
            DBObject dbObject = cursor.next();
            User user = new User();
            user.setUsername(dbObject.get("username").toString());
            user.setPassword(dbObject.get("password").toString());

            System.out.println(user.toString());
            // Adding the user details to the list.
            user_list.add(user);
        }
        return user_list;
    }

    // Add a new user to the mongo database.
    public Boolean add(User user) {
        boolean output = false;
        try {
            DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

            // Create a new object and add the new user details to this object.
            BasicDBObject doc = new BasicDBObject();
            doc.put("username", user.getUsername());
            doc.put("password", user.getPassword());

            // Save a new user to the mongo collection.
            coll.insert(doc);
            output = true;
        } catch (Exception e) {
            output = false;
        }
        return output;
    }

    // Update the selected user in the mongo database.
    public Boolean edit(User user) {
        boolean output = false;
        try {
            // Fetching the user details.
            BasicDBObject existing = (BasicDBObject) getDBObject(user.getUsername());

            DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

            // Create a new object and assign the updated details.
            BasicDBObject edited = new BasicDBObject();
            edited.put("username", user.getUsername());
            edited.put("password", user.getPassword());

            // Update the existing user to the mongo database.
            coll.update(existing, edited);
            output = true;
        } catch (Exception e) {
            output = false;
        }
        return output;
    }

    // Delete a user from the mongo database.
    public Boolean delete(String id) {
        boolean output = false;
        try {
            // Fetching the required user from the mongo database.
            BasicDBObject item = (BasicDBObject) getDBObject(id);

            DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

            // Deleting the selected user from the mongo database.
            coll.remove(item);
            output = true;
        } catch (Exception e) {
            output = false;
        }
        return output;
    }

    // Fetching a particular record from the mongo database.
    private DBObject getDBObject(String id) {
        DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

        // Fetching the record object from the mongo database.
        DBObject where_query = new BasicDBObject();

        // Put the selected user_id to search.
        where_query.put("id", id);
        return coll.findOne(where_query);
    }

    // Fetching a single user details from the mongo database.
    public User findUser(String username, String password) {
        User u = new User();
        DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

        // Fetching the record object from the mongo database.
        DBObject and_query = new BasicDBObject();
        List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
        obj.add(new BasicDBObject("username", username));
        obj.add(new BasicDBObject("password", password));

        and_query.put("$and", obj);
        System.out.println("User in find user " + username + " - " + password);
        DBObject dbo = coll.findOne(and_query);
        try{
            u.setUsername(dbo.get("username").toString());
            u.setPassword(dbo.get("password").toString());
            System.out.println("User in find user 2 " + u.toString());
        }catch(NullPointerException npe){
            System.out.println(npe);
            return u;
        }


        // Return user object.
        return u;
    }


    public Coffee findBreed(String roast){

        Coffee coffee = new Coffee();
        DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

        DBObject where_query = new BasicDBObject();
        where_query.put("roast", roast);
        DBObject dbo = coll.findOne(where_query);

        try{
            coffee.setRoast(dbo.get("roast").toString());
            coffee.setBreed((String[])dbo.get("breed"));
            return coffee;
        }catch(NullPointerException npe){
            System.out.println("NullPointerException inside findBreed " + npe.toString());
        }

        return coffee;
    }

    public String[] findRoast(){

        DBCollection coll = MongoFactory.getCollection(db_name, db_collection);
        System.out.println("inside find roast22");
        DBObject where_query = new BasicDBObject();
        List<String> breeds = coll.distinct("roast");
        System.out.println("breed list size " + breeds.size());
        ArrayList<String> breed = new ArrayList<String>();

        for(Object x : breeds){
            breed.add(x.toString());
            System.out.println(x.toString());
        }

        String[] b = new String[breed.size()];
        return breed.toArray(b);
    }
}
