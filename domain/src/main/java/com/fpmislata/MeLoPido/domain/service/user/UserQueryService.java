package com.fpmislata.MeLoPido.domain.service.user;

import com.fpmislata.MeLoPido.domain.repository.UserRepository;
import com.fpmislata.MeLoPido.domain.usecase.model.command.UserCommand;
import com.fpmislata.MeLoPido.domain.usecase.user.command.DeleteUser;
import com.fpmislata.MeLoPido.domain.usecase.user.command.InsertUser;
import com.fpmislata.MeLoPido.domain.usecase.user.command.UpdateUser;

public class UserQueryService implements DeleteUser, UpdateUser, InsertUser {
    private final UserRepository userRepository;
    public UserQueryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void delete(String idUser) {

    }

    @Override
    public void insert(UserCommand user) {

    }

    @Override
    public void update(String idUser, UserCommand user) {

    }

    @Override
    public void modifyUsername(String idUser, String username) {

    }

    @Override
    public void modifyPassword(String idUser, String password) {

    }
}
