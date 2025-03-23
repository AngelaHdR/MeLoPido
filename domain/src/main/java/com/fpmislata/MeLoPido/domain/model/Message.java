package com.fpmislata.MeLoPido.domain.model;

public class Message {
    String idMessage;
    String sendDate;
    String content;
    User sender;

    public Message() {
    }

    public Message(String idMessage, String sendDate, String content, User sender) {
        this.idMessage = idMessage;
        this.sendDate = sendDate;
        this.content = content;
        this.sender = sender;
    }

    public String getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(String idMessage) {
        this.idMessage = idMessage;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
}
