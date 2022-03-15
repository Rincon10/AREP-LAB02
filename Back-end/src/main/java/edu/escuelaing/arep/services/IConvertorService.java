package edu.escuelaing.arep.services;

import com.google.gson.JsonObject;
import edu.escuelaing.arep.model.Message;
import org.bson.Document;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 3/14/2022
 * @project Back-end
 */
public interface IConvertorService {
    /**
     * Method that transform a Message Object to a Document Object (MongoDB)
     * @param message, message to transform to document object
     * @return Document, new object equivalent to the message
     */
    public Document messageToDocument(Message message);

    /**
     * Method that return a default error in JsonFormat
     * @param error, String error to set to the Json
     * @return JsonObject, the JsonObject that represents the error
     */
    public JsonObject getError(String error);
}
