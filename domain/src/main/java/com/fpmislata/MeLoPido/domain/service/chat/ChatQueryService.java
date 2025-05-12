package com.fpmislata.MeLoPido.domain.service.chat;

import com.fpmislata.MeLoPido.domain.model.Chat;
import com.fpmislata.MeLoPido.domain.repository.ChatRepository;
import com.fpmislata.MeLoPido.domain.usecase.chat.query.FindAllChatByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.chat.query.FindChatByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.ChatQueryMapper;
import com.fpmislata.MeLoPido.domain.usecase.model.query.ChatQuery;
import com.fpmislata.MeLoPido.util.exception.RessourceNotFoundException;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

public class ChatQueryService implements FindAllChatByCriterial, FindChatByCriterial {
    private final ChatRepository chatRepository;

    public ChatQueryService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public ListWithCount<ChatQuery> findAll(int page, int pageSize) {
        ListWithCount<Chat> chatList = chatRepository.findAll(page, pageSize);
        return new ListWithCount<>(chatList.getList().stream().map(ChatQueryMapper::toChatQuery).toList(), chatList.getCount());
    }

    @Override
    public ListWithCount<ChatQuery> findAllByUser(int page, int pageSize, String idUser) {
        ListWithCount<Chat> chatList = chatRepository.findAllByUser(page, pageSize, idUser);
        return new ListWithCount<>(chatList.getList().stream().map(ChatQueryMapper::toChatQuery).toList(), chatList.getCount());
    }

    @Override
    public ChatQuery findById(String idChat) {
        return ChatQueryMapper.toChatQuery(chatRepository.findById(idChat).orElseThrow(() -> new RessourceNotFoundException("Chat not found")));
    }

    @Override
    public ChatQuery findByProductId(String idProduct) {
        return ChatQueryMapper.toChatQuery(chatRepository.findByIdProduct(idProduct).orElseThrow(() -> new RessourceNotFoundException("Chat not found")));
    }
}
