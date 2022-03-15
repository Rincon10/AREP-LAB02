package edu.escuelaing.arep.services.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import edu.escuelaing.arep.model.Message;
import edu.escuelaing.arep.services.IConvertorService;
import edu.escuelaing.arep.services.IMessageService;


import com.mongodb.client.*;
import com.mongodb.ConnectionString;
import org.bson.Document;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 3/14/2022
 * @project Back-end
 */
public class MessageService implements IMessageService {
    private MongoClient mongoClient;
    private IConvertorService service = new ConvertorService();
    private final static String URL = "mongodb+srv://admin:admin@mycluster.79lwk.mongodb.net/?retryWrites=true&w=majority";

    public MessageService() {
        ConnectionString connection = new ConnectionString(URL);
        this.mongoClient = MongoClients.create(connection);
    }

    public MessageService(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }


    @Override
    public void postMessage(Message message) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("ArepMongo");
        MongoCollection<Document> collection = mongoDatabase.getCollection("messages");

        Document document = service.messageToDocument(message);
        collection.insertOne(document);
    }

    @Override
    public List<String> getAllMessages() {
        List<String> messages = new ArrayList<>();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("ArepMongo");
        MongoCollection<Document> collection = mongoDatabase.getCollection("messages");

        FindIterable fit = collection.find();
        ArrayList<Document> docs = new ArrayList<>();

        fit.into(docs);
        docs.forEach(document -> {
            String message = document.toJson();
            messages.add(message);
        });
        return messages;
    }
}
