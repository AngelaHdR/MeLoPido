package com.fpmislata.MeLoPido.persistence.dao.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "groups_detail")
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_group")
    private String idGroup;
    private String name;
    private String icon;
    private String theme;
    private String description;
    @ManyToMany(mappedBy = "groups", cascade = CascadeType.ALL)
    private List<UserEntity> users;

    public GroupEntity() {
    }

    public GroupEntity(String idGroup, String name, String icon, String theme, String description) {
        this.idGroup = idGroup;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.theme = theme;
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

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
