package com.fpmislata.MeLoPido.domain.usecase.model.query;

import java.util.List;

public class GroupQuery {
    String idGroup;
    String name;
    String icon;
    String theme;
    String description;
    List<String> users;
    List<LetterBasicQuery> letters;

    public GroupQuery() {
    }

    public GroupQuery(String idGroup, String name, String icon, String theme, String description) {
        this.idGroup = idGroup;
        this.name = name;
        this.icon = icon;
        this.theme = theme;
        this.description = description;
    }

    public GroupQuery(String idGroup, String name, String icon, String theme, String description, List<String> users, List<LetterBasicQuery> letters) {
        this.idGroup = idGroup;
        this.name = name;
        this.icon = icon;
        this.theme = theme;
        this.description = description;
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

    public String getTheme() {
        return theme;
    }

    public String getDescription() {
        return description;
    }
}