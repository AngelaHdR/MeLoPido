package com.fpmislata.MeLoPido.persistence.dao.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "messages")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_message")
    private String idMessage;
    @Column(name = "send_date")
    private String sendDate;
    private String content;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender")
    private UserEntity sender;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_chat")
    private ChatEntity chat;

    public MessageEntity() {
    }

    public MessageEntity(String idMessage, String sendDate, String content, UserEntity sender) {
        this.idMessage = idMessage;
        this.content = content;
        this.sendDate = sendDate;
        this.sender = sender;
    }

    public MessageEntity(String idMessage, String sendDate, String content, UserEntity sender, ChatEntity chat) {
        this.idMessage = idMessage;
        this.content = content;
        this.sendDate = sendDate;
        this.sender = sender;
        this.chat = chat;
    }

    public String getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(String idMessage) {
        this.idMessage = idMessage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public UserEntity getSender() {
        return sender;
    }

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

    public ChatEntity getChat() {
        return chat;
    }

    public void setChat(ChatEntity chat) {
        this.chat = chat;
    }
}
