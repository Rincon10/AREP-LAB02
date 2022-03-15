package edu.escuelaing.arep.model;

import java.util.UUID;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 3/14/2022
 * @project Back-end
 */
public class Message {
    private String id;
    private String description;
    private String creationDate;

    public Message(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.creationDate = java.time.LocalDate.now().toString();
    }

    public Message(String id, String description, String creationDate) {
        this.id = id;
        this.description = description;
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
