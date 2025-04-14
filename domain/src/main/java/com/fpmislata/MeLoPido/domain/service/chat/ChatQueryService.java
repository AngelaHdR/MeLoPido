package com.fpmislata.MeLoPido.domain.service.chat;

import com.fpmislata.MeLoPido.domain.model.Chat;
import com.fpmislata.MeLoPido.domain.repository.ChatRepository;
import com.fpmislata.MeLoPido.domain.usecase.chat.query.FindAllChatByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.chat.query.FindChatByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.model.query.ChatQuery;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

public class ChatQueryService implements FindAllChatByCriterial, FindChatByCriterial {
    private final ChatRepository chatRepository;

    public ChatQueryService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public ListWithCount<Chat> findAll(int page, int pageSize) {
        return null;
    }

    @Override
    public ListWithCount<Chat> findAllByUser(int page, int pageSize, String idUser) {
        return null;
    }

    @Override
    public ChatQuery findById(String idChat) {
        return null;
    }

    @Override
    public ChatQuery findByProductId(String idProduct) {
        return null;
    }
}
