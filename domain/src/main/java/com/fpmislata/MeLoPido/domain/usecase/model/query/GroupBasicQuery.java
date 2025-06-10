package com.fpmislata.MeLoPido.domain.usecase.model.query;

import java.util.List;
import java.util.Objects;

public class GroupBasicQuery {
    String idGroup;
    String name;

    public GroupBasicQuery() {
    }

    public GroupBasicQuery(String idGroup, String name) {
        this.idGroup = idGroup;
        this.name = name;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public String getName() {
        return name;
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
