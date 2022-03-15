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
    public void postMessage( Message message);

    public List<String> getAllMessages();
}
