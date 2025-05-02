package com.fpmislata.MeLoPido.domain.usecase.model.query;

import java.util.List;
import java.util.Objects;

public class GroupBasicQuery {
    String idGroup;
    String name;
    String icon;
    List<String> users;

    public GroupBasicQuery() {
    }

    public GroupBasicQuery(String idGroup, String name, String icon) {
        this.idGroup = idGroup;
        this.name = name;
        this.icon = icon;
    }

    public GroupBasicQuery(String idGroup, String name, String icon, List<String> users) {
        this.idGroup = idGroup;
        this.name = name;
        this.icon = icon;
        this.users = users;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GroupBasicQuery that = (GroupBasicQuery) o;
        return Objects.equals(idGroup, that.idGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idGroup);
    }
}
