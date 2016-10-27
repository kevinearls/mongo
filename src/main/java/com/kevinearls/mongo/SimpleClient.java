package com.kevinearls.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

/**
 * Created by kearls on 26/10/2016.
 */
public class SimpleClient {
    public static void main(String[] args) {
        MongoClient client = new MongoClient("localhost", 27017);

        MongoDatabase db = client.getDatabase("fred");

        List<MongoCredential> credentials = client.getCredentialsList();
        System.out.println("CredentialsList.size) " + credentials.size());


        MongoCollection<Document> userTable = db.getCollection("users");
        Document dbObject = new Document();
        dbObject.put("one", "1");
        dbObject.put("two", "2");
        dbObject.put("three", "3");

        userTable.insertOne(dbObject);

        FindIterable<Document> blah = userTable.find();
        for (Document d : blah) {
            System.out.println(blah.first().toJson());
        }



    }
}
