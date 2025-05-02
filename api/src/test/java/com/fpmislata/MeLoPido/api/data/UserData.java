package com.fpmislata.MeLoPido.api.data;

import com.fpmislata.MeLoPido.domain.model.User;
import com.fpmislata.model.data.GroupData;

import java.util.List;

public class UserData {
    private static final List<User> users = List.of(
            new User("1", "User 1", "Surname1 1", "Surname2 1", "email 1", "10/04/1998", List.of(
                    GroupData.getGroups().get(0),
                    GroupData.getGroups().get(1)
            ), "username1", "password1"),
            new User("2", "User 2", "Surname1 2", "Surname2 2", "email 2", "10/04/1998", List.of(
                    GroupData.getGroups().get(1)
            ), "username2", "password2"),
            new User("3", "User 3", "Surname1 3", "Surname2 3", "email 3", "10/04/1998", List.of(
                    GroupData.getGroups().get(2)
            ), "username3", "password3")
    );

    private static final List<String> usersName = List.of(
            "User 1 Surname1 1 Surname2 1",
            "User 2 Surname1 2 Surname2 2",
            "User 3 Surname1 3 Surname2 3"
    );

    public static List<User> getUsers() {
        return users;
    }

    public static List<String> getUsersName() {
        return usersName;
    }
}