package com.fpmislata.MeLoPido.domain.usecase.model.mapper;

import com.fpmislata.MeLoPido.domain.model.User;
import com.fpmislata.MeLoPido.domain.usecase.model.command.UserCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.UserBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.UserQuery;

import java.util.List;

public class UserQueryMapper {
    public static UserQuery toUserQuery(User user){
        if(user == null){
            return null;
        }
        return new UserQuery(
                user.getIdUser(),
                user.getNameComplete(),
                user.getEmail(),
                user.getBirthDate(),
                user.getUsername(),
                user.getPassword(),
                user.getGroups().stream().map(GroupQueryMapper::toGroupBasicQuery).toList()
        );
    }

    public static UserBasicQuery toUserBasicQuery(User user){
        if(user == null){
            return null;
        }
        return new UserBasicQuery(
                user.getIdUser(),
                user.getNameComplete()
        );
    }

    public static List<UserBasicQuery> toUserBasicQueryList(List<User> users){
        if(users == null){
            return null;
        }
        return users.stream()
                .map(UserQueryMapper::toUserBasicQuery)
                .toList();
    }

    public static User toUser(UserCommand userCommand){
        if(userCommand == null){
            return null;
        }
        return new User(
                userCommand.idUser(),
                userCommand.name(),
                userCommand.surname1(),
                userCommand.surname2(),
                userCommand.email(),
                userCommand.birthDate(),
                userCommand.username(),
                userCommand.password()
        );
    }
}
