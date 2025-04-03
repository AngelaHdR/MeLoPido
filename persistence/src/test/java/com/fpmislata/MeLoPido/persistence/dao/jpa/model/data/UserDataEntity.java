package com.fpmislata.MeLoPido.persistence.dao.jpa.model.data;

import com.fpmislata.MeLoPido.domain.usecase.model.command.UserCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.UserBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.UserQuery;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.UserEntity;

import java.util.List;

public class UserDataEntity {
    private static final List<UserEntity> usersEntity = List.of(
            new UserEntity("1","User 1", "Surname1 1", "Surname2 1", "email 1", "2000-04-21", GroupDataEntity.getGroupsEntity(), "username 1", "password 1"),
            new UserEntity("2","User 2", "Surname1 2", "Surname2 2", "email 2", "2000-04-22", GroupDataEntity.getGroupsEntity(), "username 2", "password 2"),
            new UserEntity("3","User 3", "Surname1 3", "Surname2 3", "email 3", "2000-04-23", GroupDataEntity.getGroupsEntity(), "username 3", "password 3")
    );


    public static List<UserEntity> getUsersEntity(){
        return usersEntity;
    }

}
