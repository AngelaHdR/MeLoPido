package com.fpmislata.MeLoPido.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(idChat, chat.idChat);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idChat);
    }
}
