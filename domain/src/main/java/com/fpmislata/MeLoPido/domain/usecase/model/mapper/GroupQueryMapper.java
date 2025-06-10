package com.fpmislata.MeLoPido.domain.usecase.model.mapper;

import com.fpmislata.MeLoPido.domain.model.Group;
import com.fpmislata.MeLoPido.domain.usecase.model.command.GroupCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupQuery;

import java.util.List;

public class GroupQueryMapper {
    public static GroupQuery toGroupQuery(Group group){
        if(group == null){
            return null;
        }
        return new GroupQuery(
                group.getIdGroup(),
                group.getName(),
                group.getIcon(),
                group.getTheme(),
                group.getDescription()
        );
    }

    public static List<GroupQuery> toGroupQueryList(List<Group> groups){
        if(groups == null){
            return null;
        }
        return groups.stream()
                .map(GroupQueryMapper::toGroupQuery)
                .toList();
    }

    public static GroupBasicQuery toGroupBasicQuery(Group group){
        if(group == null){
            return null;
        }
        return new GroupBasicQuery(
                group.getIdGroup(),
                group.getName()
        );
    }

    public static List<GroupBasicQuery> toGroupBasicQueryList(List<Group> groups){
        if(groups == null){
            return null;
        }
        return groups.stream()
                .map(GroupQueryMapper::toGroupBasicQuery)
                .toList();
    }

    public static Group toGroup(GroupCommand groupCommand){
        if(groupCommand == null){
            return null;
        }
        return new Group(
                groupCommand.idGroup(),
                groupCommand.name(),
                groupCommand.icon(),
                groupCommand.theme(),
                groupCommand.description()
        );
    }
}
