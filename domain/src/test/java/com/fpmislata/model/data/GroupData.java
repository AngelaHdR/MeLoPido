package com.fpmislata.model.data;

import com.fpmislata.MeLoPido.domain.model.Group;

import java.util.List;

public class GroupData {
    private static final List<Group> groups = List.of(
            new Group("1","Group 1", "Icon 1", "Theme 1", "Description 1"),
            new Group("2","Group 2", "Icon 2","Theme 2", "Description 2"),
            new Group("3","Group 3", "Icon 3","Theme 3", "Description 3")
    );

    private static final List<String> groupsName = List.of(
            "Group 1",
            "Group 2",
            "Group 3"
    );

    public static List<Group> getGroups(){
        return groups;
    }

    public static List<String> getGroupsName(){
        return groupsName;
    }
}
