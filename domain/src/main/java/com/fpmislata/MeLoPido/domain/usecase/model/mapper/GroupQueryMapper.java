package com.fpmislata.MeLoPido.domain.usecase.model.mapper;

import com.fpmislata.MeLoPido.domain.model.Group;
import com.fpmislata.MeLoPido.domain.usecase.model.command.GroupCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupQuery;

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

    public static GroupBasicQuery toGroupBasicQuery(Group group){
        if(group == null){
            return null;
        }
        return new GroupBasicQuery(
                group.getIdGroup(),
                group.getName(),
                group.getIcon()
        );
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
