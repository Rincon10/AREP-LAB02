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

    public Document messageToDocument(Message message);

    public JsonObject getError(String error);
}
