package com.fpmislata.MeLoPido.domain.usecase.user.command;

import com.fpmislata.MeLoPido.domain.usecase.model.command.UserCommand;

public interface UpdateUser {
    void update(String idUser, UserCommand user);
    void addToGroup(String idUser, String idGroup);
}
