package com.fpmislata.MeLoPido.domain.usecase.model.mapper;

import com.fpmislata.MeLoPido.domain.model.User;
import com.fpmislata.MeLoPido.domain.usecase.model.command.UserCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.UserBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.UserQuery;

public class UserQueryMapper {
    public static UserQuery toUserQuery(User user){
        return new UserQuery(
                user.getIdUser(),
                user.getNameComplete(),
                user.getEmail(),
                user.getBirthDate()
                //añadir cartas en caso de uso
                //añadir productos en caso de uso
        );
    }

    public static UserBasicQuery toUserCollectionQuery(User user){
        return new UserBasicQuery(
                user.getIdUser(),
                user.getNameComplete()
        );
    }

    public static User toUser(UserCommand userCommand){
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
