package com.fpmislata.MeLoPido.domain.usecase.chat.command;

import com.fpmislata.MeLoPido.domain.usecase.model.command.MessageCommand;

public interface UpdateChat {
    void sendMessage(String idChat, MessageCommand message);
}
