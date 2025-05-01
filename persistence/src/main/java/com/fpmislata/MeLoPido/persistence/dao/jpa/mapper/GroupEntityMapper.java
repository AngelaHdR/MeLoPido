package com.fpmislata.MeLoPido.persistence.dao.jpa.mapper;

import com.fpmislata.MeLoPido.domain.model.Group;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.GroupEntity;

public class GroupEntityMapper {
    public static Group toGroup(GroupEntity groupEntity){
        Group group = new Group();
        group.setIdGroup(groupEntity.getIdGroup());
        group.setName(groupEntity.getName());
        group.setDescription(groupEntity.getDescription());
        group.setIcon(groupEntity.getIcon());
        group.setTheme(groupEntity.getTheme());
        //TODO: como se añaden los usuarios?
        return group;
    }

    public static GroupEntity toGroupEntity(Group group){
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setIdGroup(group.getIdGroup());
        groupEntity.setName(group.getName());
        groupEntity.setDescription(group.getDescription());
        groupEntity.setIcon(group.getIcon());
        groupEntity.setTheme(group.getTheme());
        return groupEntity;
    }
}
