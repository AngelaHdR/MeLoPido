package com.fpmislata.MeLoPido.persistence.repository.impl.chat;

import com.fpmislata.MeLoPido.domain.model.Chat;
import com.fpmislata.MeLoPido.domain.repository.ChatRepository;
import com.fpmislata.MeLoPido.persistence.dao.ChatDao;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.ChatEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.mapper.ChatEntityMapper;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.List;
import java.util.Optional;

public class ChatRepositoryImpl implements ChatRepository {
    private ChatDao chatDao;

    public ChatRepositoryImpl(ChatDao chatDao) {
        this.chatDao = chatDao;
    }

    @Override
    public ListWithCount<Chat> findAllByUser(int page, int pageSize, String idUser) {
        ListWithCount<ChatEntity> list = chatDao.findAllByUser(page, pageSize, idUser);
        List<Chat> chats = list.getList().stream().map(ChatEntityMapper::toChat).toList();
        return new ListWithCount<>(chats, list.getCount());
    }

    @Override
    public Optional<Chat> findByIdProduct(String idProduct) {
        return chatDao.findByIdProduct(idProduct).map(ChatEntityMapper::toChat);
    }

    @Override
    public ListWithCount<Chat> findAll(int page, int pageSize) {
        ListWithCount<ChatEntity> list = chatDao.findAll(page, pageSize);
        List<Chat> chats = list.getList().stream().map(ChatEntityMapper::toChat).toList();
        return new ListWithCount<>(chats, list.getCount());
    }

    @Override
    public Optional<Chat> findById(String id) {
        return chatDao.findById(id).map(ChatEntityMapper::toChat);
    }

    @Override
    public String save(Chat chat) {
        chatDao.save(ChatEntityMapper.toChatEntity(chat));
        return null;
    }

    @Override
    public void delete(String id) {
        chatDao.delete(id);
    }
}
