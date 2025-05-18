package com.fpmislata.MeLoPido.domain.usecase.user.command;

import com.fpmislata.MeLoPido.domain.usecase.model.command.UserCommand;

public interface InsertUser {
    String insert(UserCommand user);
}
