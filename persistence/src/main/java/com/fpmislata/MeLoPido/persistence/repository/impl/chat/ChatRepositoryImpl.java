package com.fpmislata.MeLoPido.persistence.repository.impl.chat;

import com.fpmislata.MeLoPido.domain.model.Chat;
import com.fpmislata.MeLoPido.domain.repository.ChatRepository;
import com.fpmislata.MeLoPido.persistence.dao.jpa.repository.ChatJpaRepository;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.Optional;

public class ChatRepositoryImpl implements ChatRepository {
    private ChatJpaRepository chatJpaRepository;
    @Override
    public ListWithCount<Chat> findAllByUser(int page, int pageSize, String idUser) {
        return null;
    }

    @Override
    public Optional<Chat> findByIdProduct(String idProduct) {
        return Optional.empty();
    }

    @Override
    public ListWithCount<Chat> findAll(int page, int pageSize) {
        return null;
    }

    @Override
    public Optional<Chat> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void save(Chat chat) {

    }

    @Override
    public void delete(String id) {

    }
}
