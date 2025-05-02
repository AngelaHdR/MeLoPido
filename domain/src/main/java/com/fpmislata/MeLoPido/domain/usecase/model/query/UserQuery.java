package com.fpmislata.MeLoPido.domain.usecase.model.query;

import java.util.List;
import java.util.Objects;

public class UserQuery {
    String idUser;
    String nameComplete;
    String email;
    String birthDate;
    List<GroupBasicQuery> groups;
    String username;
    String password;
    List<LetterBasicQuery> letters;
    List<ProductBasicQuery> products;

    public UserQuery(String idUser, String nameComplete, String email, String birthDate, List<GroupBasicQuery> groups, String username, String password,List<LetterBasicQuery> letters, List<ProductBasicQuery> products) {
        this.idUser = idUser;
        this.nameComplete = nameComplete;
        this.email = email;
        this.birthDate = birthDate;
        this.username = username;
        this.password = password;
        this.letters = letters;
        this.products = products;
        this.groups = groups;
    }

    public UserQuery(String idUser, String nameComplete, String email, String birthDate,List<GroupBasicQuery> groups,String username, String password) {
        this.idUser = idUser;
        this.nameComplete = nameComplete;
        this.email = email;
        this.birthDate = birthDate;
        this.username = username;
        this.password = password;
        this.groups = groups;
    }

    public UserQuery() {
    }

    public String getIdUser() {
        return idUser;
    }

    public String getNameComplete() {
        return nameComplete;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<LetterBasicQuery> getLetters() {
        return letters;
    }

    public void setLetters(List<LetterBasicQuery> letters) {
        this.letters = letters;
    }

    public List<ProductBasicQuery> getProducts() {
        return products;
    }

    public void setProducts(List<ProductBasicQuery> products) {
        this.products = products;
    }

    public List<GroupBasicQuery> getGroups() {
        return groups;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserQuery userQuery = (UserQuery) o;
        return Objects.equals(idUser, userQuery.idUser);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idUser);
    }
}
