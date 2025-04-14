package com.fpmislata.MeLoPido.domain.usecase.user.command;

import com.fpmislata.MeLoPido.domain.usecase.model.command.UserCommand;

public interface UpdateUser {
    void update(String idUser, UserCommand user);
    void modifyUsername(String idUser, String username);
    void modifyPassword(String idUser, String password);
}
