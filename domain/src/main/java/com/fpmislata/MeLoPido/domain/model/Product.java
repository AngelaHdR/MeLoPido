package com.fpmislata.MeLoPido.domain.model;

import java.util.Objects;

public class Product {
    String idProduct;
    String name;
    String detail;
    String url;
    String state; //Enum: available, selected, delivered
    User assigned;
    Chat chat;

    public Product() {
    }

    public Product(String idProduct, String name, String detail, String url, String state) {
        this.idProduct = idProduct;
        this.url = url;
        this.name = name;
        this.detail = detail;
        this.state = state;
    }

    public Product(String idProduct, String name, String detail, String url, String state, User assigned) {
        this.idProduct = idProduct;
        this.name = name;
        this.detail = detail;
        this.url = url;
        this.state = state;
        this.assigned = assigned;
    }

    public Product(String idProduct, String name, String detail, String url, String state, User assigned, Chat chat) {
        this.idProduct = idProduct;
        this.name = name;
        this.detail = detail;
        this.url = url;
        this.state = state;
        this.assigned = assigned;
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

    public User getAssigned() {
        return assigned;
    }

    public void setAssigned(User assigned) {
        this.assigned = assigned;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(idProduct, product.idProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idProduct);
    }
}
