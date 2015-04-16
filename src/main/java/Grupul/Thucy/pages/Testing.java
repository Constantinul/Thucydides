package Grupul.Thucy.pages;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Testing {

    public static void main(String[] args) throws UnknownHostException {
        List<String> arrayList = new ArrayList<String>();
        LinkedList<String> linkedList = new LinkedList<String>();
        Set<String> set = new HashSet<String>();
        Map<String, String> map = new HashMap<String, String>();

        MongoClient mongoClient = new MongoClient("localhost");
        DB database = mongoClient.getDB("RenaultBRTest");

        DBCollection collection = database.getCollection("tralala");
        BasicDBObject objectOfInterest = new BasicDBObject("_id", "aidi");
        BasicDBObject d = (BasicDBObject) collection.find(objectOfInterest).next();
        d.removeField("contact");
        collection.update(objectOfInterest, d);

        System.out.println("ran");

    }
}
