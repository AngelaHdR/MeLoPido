package com.fpmislata.MeLoPido.domain.model;

import java.util.List;

public class Letter {
    String idLetter;
    String description;
    String creationDate;
    String sendDate;
    User user;
    Group group;
    List<Product> products;

    public Letter() {
    }

    public Letter(String idLetter, String description, String creationDate, User user, List<Product> products) {
        this.idLetter = idLetter;
        this.description = description;
        this.creationDate = creationDate;
        this.user = user;
        this.products = products;
    }

    public Letter(String idLetter, String description, String creationDate, String sendDate, User user, Group group, List<Product> products) {
        this.idLetter = idLetter;
        this.description = description;
        this.sendDate = sendDate;
        this.creationDate = creationDate;
        this.user = user;
        this.group = group;
        this.products = products;
    }

    public String getIdLetter() {
        return idLetter;
    }

    public void setIdLetter(String idLetter) {
        this.idLetter = idLetter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
