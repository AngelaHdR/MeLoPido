package com.fpmislata.MeLoPido.domain.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(idMessage, message.idMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idMessage);
    }
}
