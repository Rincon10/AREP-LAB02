package edu.escuelaing.arep.services;

import com.google.gson.JsonObject;
import edu.escuelaing.arep.model.Message;

import java.util.List;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 3/14/2022
 * @project Back-end
 */
public interface IMessageService {
    /**
     * Method that insert a Message on the Mongo DB
     * @param message, Message that is gonna be inserted
     */
    public void postMessage( Message message);

    /**
     * Method that query all the messages from the Db
     * @return List<String> List of messages on JsonFormat
     */
    public List<String> getAllMessages();
}
