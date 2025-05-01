package com.fpmislata.MeLoPido.domain.model;

import java.util.Objects;

public class Group {
    String idGroup;
    String name;
    String icon;
    String theme; //ENUM('3_wise_men', 'birthday', 'secret_santa', 'general')
    String description;

    public Group() {
    }

    public Group(String idGroup) {
        this.idGroup = idGroup;
    }

    public Group(String idGroup, String name, String icon, String theme, String description) {
        this.idGroup = idGroup;
        this.name = name;
        this.icon = icon;
        this.theme = theme;
        this.description = description;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(idGroup, group.idGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idGroup);
    }
}
