package edu.escuelaing.arep.services;

import java.io.IOException;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 3/19/2022
 * @project Back-end
 */
public interface IHttpConnectionService {

    /**
     * Method that return the JsonObject of our petition
     *
     * @return String, response of the petition
     * @throws IOException
     */
    public String getResponse() throws IOException;

    public String postPetition() throws IOException;

    public String startConnection(String method) throws IOException;

}
