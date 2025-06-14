package com.example.myhelpdeskapp;

public class Ticket {
    private Long id;
    private String title;
    private String description;
    private String status;
    private String contact;
    public Ticket() {
    }
    public Ticket(String title, String description, String status, String contact) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.contact = contact;
    }
    public Ticket(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // Gettery i settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
