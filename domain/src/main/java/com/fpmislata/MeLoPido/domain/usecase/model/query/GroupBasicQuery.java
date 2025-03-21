package com.fpmislata.MeLoPido.domain.usecase.model.query;

import java.util.List;

public class GroupBasicQuery {
    Integer idGroup;
    String name;
    String icon;
    List<String> users;

    public GroupBasicQuery() {
    }

    public GroupBasicQuery(Integer idGroup, String name, String icon) {
        this.idGroup = idGroup;
        this.name = name;
        this.icon = icon;
    }

    public GroupBasicQuery(Integer idGroup, String name, String icon, List<String> users) {
        this.idGroup = idGroup;
        this.name = name;
        this.icon = icon;
        this.users = users;
    }

    public Integer getIdGroup() {
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
}
