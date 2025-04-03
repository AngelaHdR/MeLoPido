package com.fpmislata.MeLoPido.domain.model;

public class Product {
    String idProduct;
    String name;
    String detail;
    String url;
    String state; //Enum: available, selected, delivered
    User asignado;
    Chat chat;

    public Product() {}

    public Product(String idProduct, String name, String detail, String url, String state) {
        this.idProduct = idProduct;
        this.url = url;
        this.name = name;
        this.detail = detail;
        this.state = state;
    }

    public Product(String idProduct, String name, String detail, String url, String state, User asignado) {
        this.idProduct = idProduct;
        this.name = name;
        this.detail = detail;
        this.url = url;
        this.state = state;
        this.asignado = asignado;
    }

    public Product(String idProduct, String name, String detail, String url, String state, User asignado, Chat chat) {
        this.idProduct = idProduct;
        this.name = name;
        this.detail = detail;
        this.url = url;
        this.state = state;
        this.asignado = asignado;
        this.chat = chat;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public User getAsignado() {
        return asignado;
    }

    public void setAsignado(User asignado) {
        this.asignado = asignado;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
