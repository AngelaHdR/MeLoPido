package com.fpmislata.MeLoPido.persistence.dao.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @Column(name = "id_product")
    private String idProduct;
    private String name;
    private String detail;
    private String url;
    private String state; //TODO: add state
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "assigned_to")
    private UserEntity asignado;
    @OneToOne(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private ChatEntity chat;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_letter")
    private LetterEntity letter;

    public ProductEntity() {
    }

    public ProductEntity(String idProduct, String name, String detail, String url, String state, UserEntity asignado, ChatEntity chat) {
        this.idProduct = idProduct;
        this.name = name;
        this.detail = detail;
        this.url = url;
        this.state = state;
        this.asignado = asignado;
        this.chat = chat;
    }

    public ProductEntity(String idProduct, String name, String detail, String url, String state, LetterEntity letter, UserEntity asignado, ChatEntity chat) {
        this.idProduct = idProduct;
        this.name = name;
        this.detail = detail;
        this.url = url;
        this.state = state;
        this.letter = letter;
        this.asignado = asignado;
        this.chat = chat;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LetterEntity getLetter() {
        return letter;
    }

    public void setLetter(LetterEntity letter) {
        this.letter = letter;
    }

    public UserEntity getAsignado() {
        return asignado;
    }

    public void setAsignado(UserEntity asignado) {
        this.asignado = asignado;
    }

    public ChatEntity getChat() {
        return chat;
    }

    public void setChat(ChatEntity chat) {
        this.chat = chat;
    }
}
