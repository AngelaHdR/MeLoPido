package com.fpmislata.MeLoPido.persistence.dao.jpa.mapper;

import com.fpmislata.MeLoPido.domain.model.Group;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.GroupEntity;

import java.util.List;

public class GroupEntityMapper {
    public static Group toGroup(GroupEntity groupEntity){
        if (groupEntity == null) {
            return null;
        }
        Group group = new Group();
        group.setIdGroup(groupEntity.getIdGroup());
        group.setName(groupEntity.getName());
        group.setDescription(groupEntity.getDescription());
        group.setIcon(groupEntity.getIcon());
        group.setTheme(groupEntity.getTheme());
        return group;
    }

    public static List<Group> toGroupList(List<GroupEntity> groupEntityList){
        if (groupEntityList == null) {
            return null;
        }
        return groupEntityList.stream().map(GroupEntityMapper::toGroup).toList();
    }

    public static GroupEntity toGroupEntity(Group group){
        if (group == null) {
            return null;
        }
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setIdGroup(group.getIdGroup());
        groupEntity.setName(group.getName());
        groupEntity.setDescription(group.getDescription());
        groupEntity.setIcon(group.getIcon());
        groupEntity.setTheme(group.getTheme());
        return groupEntity;
    }
}
