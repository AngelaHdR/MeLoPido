package com.fpmislata.usecase.model.data;

import com.fpmislata.MeLoPido.domain.usecase.model.command.GroupCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupQuery;
import com.fpmislata.model.data.UserData;

import java.util.List;

public class GroupDataUC {
    private static final List<GroupQuery> groupsQuery = List.of(
            /*new GroupQuery("1", "Group 1", "Icon 1", "Theme 1", "Description 1", UserData.getUsersName(), LetterDataUC.getLettersBasicQuery()),
            new GroupQuery("2", "Group 2", "Icon 2", "Theme 2", "Description 2", UserData.getUsersName(), LetterDataUC.getLettersBasicQuery()),
            new GroupQuery("3", "Group 3", "Icon 3", "Theme 3", "Description 3", UserData.getUsersName(), LetterDataUC.getLettersBasicQuery())*/
    );

    private static final List<GroupBasicQuery> groupsBasicQuery = List.of(
            new GroupBasicQuery("1", "Group 1", "Icon 1", UserData.getUsersName()),
            new GroupBasicQuery("2", "Group 2", "Icon 2", UserData.getUsersName()),
            new GroupBasicQuery("3", "Group 3", "Icon 3", UserData.getUsersName())
    );

    private static final List<GroupCommand> groupsCommand = List.of(
            new GroupCommand("1", "Group 1", "Icon 1", "Theme 1", "Description 1"),
            new GroupCommand("2", "Group 2", "Icon 2", "Theme 2", "Description 2"),
            new GroupCommand("3", "Group 3", "Icon 3", "Theme 3", "Description 3")
    );

    public static List<GroupQuery> getGroupsQuery(){
        return groupsQuery;
    }

    public static List<GroupBasicQuery> getGroupsBasicQuery(){
        return groupsBasicQuery;
    }

    public static List<GroupCommand> getGroupsCommand(){
        return groupsCommand;
    }
}
