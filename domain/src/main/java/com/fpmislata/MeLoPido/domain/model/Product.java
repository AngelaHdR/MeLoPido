package com.fpmislata.MeLoPido.domain.model;

public class Product {
    String idProduct;
    String name;
    String detail;
    String url;
    User asignado;
    Chat chat;

    public Product() {
        this.chat = new Chat();
    }

    public Product(String idProduct, String name, String detail, String url) {
        this.idProduct = idProduct;
        this.url = url;
        this.name = name;
        this.detail = detail;
        this.chat = new Chat();
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
}
