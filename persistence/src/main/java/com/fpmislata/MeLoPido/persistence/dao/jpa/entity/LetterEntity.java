package com.fpmislata.MeLoPido.persistence.dao.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "letters")
public class LetterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_letter")
    private String idLetter;
    private String description;
    @Column(name = "creation_date")
    private String creationDate;
    @Column(name = "send_date")
    private String sendDate;
    @Column(name = "expiration_date")
    private String expirationDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private UserEntity user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_group")
    private GroupEntity group;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "letter")
    private List<ProductEntity> products;

    public LetterEntity() {
    }

    public LetterEntity(String idLetter, String description, String creationDate, String sendDate, String expirationDate, UserEntity user, GroupEntity group, List<ProductEntity> products) {
        this.idLetter = idLetter;
        this.description = description;
        this.creationDate = creationDate;
        this.sendDate = sendDate;
        this.expirationDate = expirationDate;
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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
