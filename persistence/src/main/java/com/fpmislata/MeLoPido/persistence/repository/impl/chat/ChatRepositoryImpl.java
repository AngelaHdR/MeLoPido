package com.fpmislata.MeLoPido.persistence.repository.impl.chat;

import com.fpmislata.MeLoPido.domain.model.Chat;
import com.fpmislata.MeLoPido.domain.repository.ChatRepository;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.ChatEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.mapper.ChatEntityMapper;
import com.fpmislata.MeLoPido.persistence.dao.jpa.repository.ChatJpaRepository;
import com.fpmislata.MeLoPido.persistence.dao.jpa.repository.MessageJpaRepository;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class ChatRepositoryImpl implements ChatRepository {
    private ChatJpaRepository chatJpaRepository;
    private MessageJpaRepository messageJpaRepository;

    public ChatRepositoryImpl(ChatJpaRepository chatJpaRepository) {
        this.chatJpaRepository = chatJpaRepository;
    }
    //TODO: hacer con el message repository o mezclar la consulta con la de chat

    @Override
    public ListWithCount<Chat> findAllByUser(int page, int pageSize, String idUser) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<ChatEntity> pages = chatJpaRepository.findAllByUser(pageable, idUser);
        List<Chat> chats = pages.getContent().stream().map(this::completeChat).map(ChatEntityMapper::toChat).toList();
        return new ListWithCount<>(chats, pages.getTotalElements());
    }

    @Override
    public Optional<Chat> findByIdProduct(String idProduct) {
        return chatJpaRepository.findByIdProduct(idProduct).map(ChatEntityMapper::toChat);
    }

    @Override
    public ListWithCount<Chat> findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<ChatEntity> pages = chatJpaRepository.findAll(pageable);
        List<Chat> chats = pages.getContent().stream().map(this::completeChat).map(ChatEntityMapper::toChat).toList();
        return new ListWithCount<>(chats, pages.getTotalElements());
    }

    @Override
    public Optional<Chat> findById(String id) {
        return chatJpaRepository.findById(id).map(ChatEntityMapper::toChat);
    }

    @Override
    public void save(Chat chat) {
        chatJpaRepository.save(ChatEntityMapper.toChatEntity(chat));
    }

    @Override
    public void delete(String id) {
        chatJpaRepository.deleteById(id);
    }

    private ChatEntity completeChat(ChatEntity chat) {
        chat.setMessages(messageJpaRepository.findAllByChat(chat.getIdChat()));
        return chat;
    }
}
