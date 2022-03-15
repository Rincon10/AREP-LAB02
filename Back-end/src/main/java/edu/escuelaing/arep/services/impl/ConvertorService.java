package edu.escuelaing.arep.services.impl;

import com.google.gson.JsonObject;
import org.bson.Document;
import edu.escuelaing.arep.model.Message;
import edu.escuelaing.arep.services.IConvertorService;
import org.eclipse.jetty.http.HttpStatus;


/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 3/14/2022
 * @project Back-end
 */
public class ConvertorService implements IConvertorService {

    public Document messageToDocument(Message message) {
        Document document = new Document();
        document.put("id", message.getId());
        document.put("creationDate", message.getCreationDate());
        document.put("description", message.getDescription());
        return document;
    }

    @Override
    public JsonObject getError(String error) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status_code",HttpStatus.BAD_REQUEST_400);
        jsonObject.addProperty("description",error);

        return jsonObject;
    }
}
