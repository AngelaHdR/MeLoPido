package com.fpmislata.MeLoPido.persistence.dao.jpa.model.data;

import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.GroupEntity;

import java.util.List;

public class GroupDataEntity {
    private static final List<GroupEntity> groupsEntity = List.of(
            new GroupEntity("1", "Group 1", "Description 1", "Icon 1", "Theme 1", UserDataEntity.getUsersEntity()),
            new GroupEntity("2", "Group 2", "Description 2", "Icon 2", "Theme 2", UserDataEntity.getUsersEntity()),
            new GroupEntity("3", "Group 3", "Description 3", "Icon 3", "Theme 3", UserDataEntity.getUsersEntity())
    );

    public static List<GroupEntity> getGroupsEntity(){
        return groupsEntity;
    }

}
