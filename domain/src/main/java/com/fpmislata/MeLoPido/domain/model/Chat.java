package com.fpmislata.MeLoPido.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    String idChat;
    String creationDate;
    List<Message> messages;

    void addMessage(Message message) {
        messages.add(message);
    }

    void removeMessage(Message message) {
        messages.remove(message);
    }

    public Chat() {
        this.messages = new ArrayList<>();
    }

    public Chat(String idChat, String creationDate) {
        this.idChat = idChat;
        this.creationDate = creationDate;
    }

    public Chat(String idChat, String creationDate, List<Message> messages) {
        this.idChat = idChat;
        this.creationDate = creationDate;
        this.messages = messages;
    }

    public String getIdChat() {
        return idChat;
    }

    public void setIdChat(String idChat) {
        this.idChat = idChat;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
