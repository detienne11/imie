package ccm.kx.rest;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TestMongo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// query
		Block<Document> printBlock = new Block<Document>() {
			@Override
			public void apply(final Document document) {
				System.out.println(document.toJson());
			}
		};

		try {

			// MongoClient mongoClient = new MongoClient("localhost", 27017);
			// mongodb://[username:password@]host1[:port1][,host2[:port2],...[,hostN[:portN]]][/[database][?options]]
			//
			String dbURI = "mongodb://localhost:27017";
			MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
			// MongoClient mongoClient = new MongoClient("localhost");

			List<String> databases = mongoClient.getDatabaseNames();

			for (String dbName : databases) {
				System.out.println("- Database: " + dbName);

				DB db = mongoClient.getDB(dbName);

				Set<String> collections = db.getCollectionNames();
				for (String collectionName : collections) {
					System.out.println("\t + Collection: " + collectionName);
				}
			}
			
			// query
			MongoDatabase database = mongoClient.getDatabase("TestNoSQl");
			MongoCollection<Document> collection = database.getCollection("users");
			
			
			// read
			collection.find().forEach(printBlock);
//			collection.find(eq("name", "456 Cookies Shop")).forEach(printBlock);


			// write
			Document document = new Document("name", "Café Con Leche")
		               .append("contact", new Document("phone", "228-555-0149")
		                                       .append("email", "cafeconleche@example.com")
		                                       .append("location",Arrays.asList(-73.92502, 40.8279556)))
		               .append("stars", 3)
		               .append("categories", Arrays.asList("Bakery", "Coffee", "Pastries"));

			collection.insertOne(document);

			mongoClient.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
