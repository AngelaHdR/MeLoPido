package com.fpmislata.MeLoPido.persistence.dao.jpa.mapper;

import com.fpmislata.MeLoPido.domain.model.User;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.UserEntity;

public class UserEntityMapper {
    public static User toUser(UserEntity userEntity){
        if (userEntity == null) {
            return null;
        }
        User user = new User();
        user.setIdUser(userEntity.getIdUser());
        user.setName(userEntity.getName());
        user.setSurname1(userEntity.getSurname1());
        user.setSurname2(userEntity.getSurname2());
        user.setEmail(userEntity.getEmail());
        user.setBirthDate(userEntity.getBirthDate());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setGroups(GroupEntityMapper.toGroupList(userEntity.getGroups()));
        return user;
    }

    public static UserEntity toUserEntity(User user){
        if (user == null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setIdUser(user.getIdUser());
        userEntity.setName(user.getName());
        userEntity.setSurname1(user.getSurname1());
        userEntity.setSurname2(user.getSurname2());
        userEntity.setEmail(user.getEmail());
        userEntity.setBirthDate(user.getBirthDate());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        if(userEntity.getGroups() != null){
            userEntity.setGroups(user.getGroups().stream().map(GroupEntityMapper::toGroupEntity).toList());
        }
        return userEntity;
    }
}
