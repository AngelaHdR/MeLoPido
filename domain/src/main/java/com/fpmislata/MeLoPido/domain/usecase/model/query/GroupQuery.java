package com.fpmislata.MeLoPido.domain.usecase.model.query;

import java.util.List;

public class GroupQuery {
    String idGroup;
    String name;
    String icon;
    List<String> users;
    List<LetterBasicQuery> letters;

    public GroupQuery() {
    }

    public GroupQuery(String idGroup, String name, String icon) {
        this.idGroup = idGroup;
        this.name = name;
        this.icon = icon;
    }

    public GroupQuery(String idGroup, String name, String icon, List<String> users, List<LetterBasicQuery> letters) {
        this.idGroup = idGroup;
        this.name = name;
        this.icon = icon;
        this.users = users;
        this.letters = letters;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public List<LetterBasicQuery> getLetters() {
        return letters;
    }

    public void setLetters(List<LetterBasicQuery> letters) {
        this.letters = letters;
    }
}