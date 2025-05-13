package com.fpmislata.MeLoPido.persistence.dao.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chats")
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_chat")
    private String idChat;
    private String creationDate;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "chat")
    private List<MessageEntity> messages;
    @OneToOne
    @JoinColumn(name = "id_product")
    private ProductEntity product;

    public ChatEntity() {
    }

    public ChatEntity(String idChat, String creationDate, List<MessageEntity> messages) {
        this.idChat = idChat;
        this.creationDate = creationDate;
        this.messages = messages;
    }

    public ChatEntity(String idChat, String creationDate, List<MessageEntity> messages, ProductEntity product) {
        this.idChat = idChat;
        this.creationDate = creationDate;
        this.product = product;
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

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public List<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageEntity> messages) {
        this.messages = messages;
    }
}
