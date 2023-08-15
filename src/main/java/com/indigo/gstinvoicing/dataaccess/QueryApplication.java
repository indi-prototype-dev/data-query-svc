package com.indigo.gstinvoicing.dataaccess;

import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;


@RestController
@SpringBootApplication
@RequestMapping("dataaccess")
public class QueryApplication {
    
    @RequestMapping("/")
    String home() {
        return "Data Access Svc!";
    }


    @GetMapping(path="/pnr/{id}",produces={ "application/json"})
    public String getPNRDetails(@PathVariable String id) {
    	  return findPNRById(id);
    }

    private String findPNRById(String id) {
    	MongoClient mongoClient = MongoClients.create("mongodb://indmongodb:j4Xc9J7xy5GUqo6y6BlK6xzbnLg7Op0TQee5Et53W9J29OIdRIwK2xY96det1Z1rWObI9fxkSguUACDbWvnoDA==@indmongodb.mongo.cosmos.azure.com:10255/?ssl=true&retrywrites=false&replicaSet=globaldb&maxIdleTimeMS=120000&appName=@indmongodb@");
    	
    	 // Get database
        MongoDatabase database = mongoClient.getDatabase("gstinvoicedb");

        // Get collection
        MongoCollection<Document> collection = database.getCollection("bookingpnrcollection");
        
        Document queryResult = collection.find(Filters.eq("PNR", id)).first();
        return queryResult.toJson();
    }
    
    @GetMapping(path="/invoice/{id}",produces={ "application/json"})
    public String getInvoiceDetails(@PathVariable String id) {
    	  return findInvoiceById(id);
    }

    private String findInvoiceById(String id) {
    	MongoClient mongoClient = MongoClients.create("mongodb://indmongodb:j4Xc9J7xy5GUqo6y6BlK6xzbnLg7Op0TQee5Et53W9J29OIdRIwK2xY96det1Z1rWObI9fxkSguUACDbWvnoDA==@indmongodb.mongo.cosmos.azure.com:10255/?ssl=true&retrywrites=false&replicaSet=globaldb&maxIdleTimeMS=120000&appName=@indmongodb@");
    	
    	// Get database
        MongoDatabase database = mongoClient.getDatabase("gstinvoicedb");

        // Get collection
        MongoCollection<Document> collection = database.getCollection("bookingpnrcollection");
        
        Document queryResult = collection.find(Filters.eq("InvoiceNumber", id)).first();
        return queryResult.toJson();
    }

    public static void main(String[] args) {
        SpringApplication.run(QueryApplication.class, args);
//    	MongoClient mongoClient = MongoClients.create("mongodb://indmongodb:j4Xc9J7xy5GUqo6y6BlK6xzbnLg7Op0TQee5Et53W9J29OIdRIwK2xY96det1Z1rWObI9fxkSguUACDbWvnoDA==@indmongodb.mongo.cosmos.azure.com:10255/?ssl=true&retrywrites=false&replicaSet=globaldb&maxIdleTimeMS=120000&appName=@indmongodb@");
//    	
//   	 // Get database
//       MongoDatabase database = mongoClient.getDatabase("gstinvoicedb");
//
//       // Get collection
//       MongoCollection<Document> collection = database.getCollection("bookingpnrcollection");
//       
//       Document queryResult = collection.find(Filters.eq("PNR", "B19OXM")).first();
//       
//       JSONObject pnrDetailsJson = new JSONObject(queryResult.toJson());
//       
//       JSONArray transactionsArrayJson = (JSONArray) pnrDetailsJson.get("Transactions");
//       JSONObject transactionJson = (JSONObject)transactionsArrayJson.get(0);
//       transactionJson.put("Flight Number",7453);
//       transactionsArrayJson.put(transactionJson);
//       
//       Document updatedDoc = Document.parse(pnrDetailsJson.toString());
//       
//       collection.replaceOne(Filters.eq("PNR", "B19OXM"), updatedDoc);
       
    }
    
//    public static void main(String[] args) {
//        // SpringApplication.run(DataAccessApplication.class, args);
//        MongoClient mongoClient = MongoClients.create("mongodb://indmongodb:j4Xc9J7xy5GUqo6y6BlK6xzbnLg7Op0TQee5Et53W9J29OIdRIwK2xY96det1Z1rWObI9fxkSguUACDbWvnoDA==@indmongodb.mongo.cosmos.azure.com:10255/?ssl=true&retrywrites=false&replicaSet=globaldb&maxIdleTimeMS=120000&appName=@indmongodb@");
//     	
//    	   // Get database
//        MongoDatabase database = mongoClient.getDatabase("gstinvoicedb");
//
//        // Get collection
//        MongoCollection<Document> collection = database.getCollection("invoicecollection");
//        
//        Document queryResult = collection.find(Filters.eq("InvoiceNumber", "CO4491327PP44221")).first();
//        
//        JSONObject pnrDetailsJson = new JSONObject(queryResult.toJson());
//        
//        JSONArray transactionsArrayJson = (JSONArray) pnrDetailsJson.get("CategorizedTransactions");
//        JSONObject transactionJson = (JSONObject)transactionsArrayJson.get(0);
//        transactionJson.put("FlightNumber",7453);
//        transactionsArrayJson.put(transactionJson);
//        
//        Document updatedDoc = Document.parse(pnrDetailsJson.toString());
//        
//        collection.replaceOne(Filters.eq("InvoiceNumber", "CO4491327PP44221"), updatedDoc);
//        
//     }
    
}
