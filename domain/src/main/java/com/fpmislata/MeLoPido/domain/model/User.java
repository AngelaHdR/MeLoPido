package com.fpmislata.MeLoPido.domain.model;

import java.util.List;
import java.util.Objects;

public class User {
    String idUser;
    String name;
    String surname1;
    String surname2;
    String nameComplete;
    String email;
    String birthDate;
    List<Group> groups;
    String username;
    String password;

    public User() {
    }

    public User(String idUser) {
        this.idUser = idUser;
    }

    public User(String idUser, String name, String surname1, String surname2, String email, String birthDate, String username, String password) {
        this.idUser = idUser;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.email = email;
        this.birthDate = birthDate;
        this.username = username;
        this.password = password;
    }

    public User(String idUser, String name, String surname1, String surname2, String email, String birthDate, List<Group> groups, String username, String password) {
        this.idUser = idUser;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.email = email;
        this.birthDate = birthDate;
        this.groups = groups;
        this.username = username;
        this.password = password;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public String getNameComplete() {
        if(surname2 == null || surname2.isEmpty()) {
            return name + " " + surname1;
        }
        return name + " " + surname1 + " " + surname2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(idUser, user.idUser);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idUser);
    }
}
