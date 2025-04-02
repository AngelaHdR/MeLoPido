package com.fpmislata.MeLoPido.persistence.dao.jpa.entity;

import com.fpmislata.MeLoPido.domain.model.Group;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "groups")
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group")
    private String idGroup;
    private String name;
    private String description;
    private String icon;
    private String theme;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "id_group"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private List<UserEntity> users;

    public GroupEntity() {
    }

    public GroupEntity(String idGroup, String name, String description, String icon, String theme) {
        this.idGroup = idGroup;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.theme = theme;
    }

    public GroupEntity(String idGroup, String name, String description, String icon, String theme, List<UserEntity> users) {
        this.idGroup = idGroup;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.theme = theme;
        this.users = users;
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

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
