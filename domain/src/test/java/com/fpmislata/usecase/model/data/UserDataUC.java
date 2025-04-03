package com.fpmislata.usecase.model.data;

import com.fpmislata.MeLoPido.domain.usecase.model.command.UserCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.UserBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.UserQuery;

import java.util.List;

public class UserDataUC {
    private static final List<UserQuery> usersQuery = List.of(
            new UserQuery("1","User 1 Surname1 1 Surname2 1", "email 1", "2000-04-21", "username 1", "password 1", GroupDataUC.getGroupsBasicQuery()),
            new UserQuery("2","User 2 Surname1 2 Surname2 2", "email 2", "2000-04-22", "username 2", "password 2", GroupDataUC.getGroupsBasicQuery()),
            new UserQuery("3","User 3 Surname1 3 Surname2 3", "email 3", "2000-04-23", "username 3", "password 3", GroupDataUC.getGroupsBasicQuery())
    );

    private static final List<UserBasicQuery> usersBasic = List.of(
            new UserBasicQuery("1", "User 1 Surname1 1 Surname2 1"),
            new UserBasicQuery("2", "User 2 Surname1 2 Surname2 2"),
            new UserBasicQuery("3", "User 3 Surname1 3 Surname2 3")
    );

    private static final List<UserCommand> usersCommand = List.of(
            new UserCommand("1", "User 1", "Surname1 1", "Surname2 1", "email 1", "2000-04-21", "username 1", "password 1"),
            new UserCommand("2", "User 2", "Surname1 2", "Surname2 2", "email 2", "2000-04-22", "username 2", "password 2"),
            new UserCommand("3", "User 3", "Surname1 3", "Surname2 3", "email 3", "2000-04-23", "username 3", "password 3")
    );

    public static List<UserQuery> getUsersQuery(){
        return usersQuery;
    }

    public static List<UserBasicQuery> getUsersBasicQuery(){
        return usersBasic;
    }

    public static List<UserCommand> getUsersCommand(){
        return usersCommand;
    }
}
