package com.example.demo.dto;

public class Message {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message attach(String message) {
        this.message = message;
        return this;
    }
}
