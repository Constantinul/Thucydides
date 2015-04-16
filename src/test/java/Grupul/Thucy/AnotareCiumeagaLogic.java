package Grupul.Thucy;

import java.lang.reflect.Field;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class AnotareCiumeagaLogic {

    public static void parse(Object obj) throws Exception {
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(AnotareCiumeaga.class)) {
                AnotareCiumeaga a = field.getAnnotation(AnotareCiumeaga.class);
                System.out.println("field isss: " + field.getName());
                System.out.println("field isss: " + field.get(obj));

                MongoClient mongoClient = new MongoClient("localhost");
                DB database = mongoClient.getDB(clazz.getSimpleName());
                DBCollection collection = database.getCollection("fielduriAnotate");

                BasicDBObject objectOfInterest = new BasicDBObject(field.getName(), field.get(obj));
                DBCursor dbc = collection.find(objectOfInterest);

                if (dbc.hasNext()) {
                    System.out.println("este deja");
                } else {
                    collection.insert(objectOfInterest);
                }
            }
        }
    }

}
