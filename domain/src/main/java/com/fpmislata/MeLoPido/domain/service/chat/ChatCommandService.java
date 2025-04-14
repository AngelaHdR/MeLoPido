package com.fpmislata.MeLoPido.domain.service.chat;

import com.fpmislata.MeLoPido.domain.repository.ChatRepository;
import com.fpmislata.MeLoPido.domain.usecase.chat.command.DeleteChat;
import com.fpmislata.MeLoPido.domain.usecase.chat.command.UpdateChat;
import com.fpmislata.MeLoPido.domain.usecase.model.command.MessageCommand;

public class ChatCommandService implements DeleteChat, UpdateChat {
    private final ChatRepository chatRepository;

    public ChatCommandService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public void deleteChat(String chatId) {

    }

    @Override
    public void sendMessage(String idChat, MessageCommand message) {

    }
}
