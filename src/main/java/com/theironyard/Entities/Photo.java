package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by branden on 3/15/16 at 10:59.
 */
@Entity
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue
    int id;

    @ManyToOne
    User sender;

    @ManyToOne
    User recipient;

    @Column(nullable = false)
    String fileName;


    public Photo() {
    }

    public Photo(User sender, User recipient, String fileName) {
        this.sender = sender;
        this.recipient = recipient;
        this.fileName = fileName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}