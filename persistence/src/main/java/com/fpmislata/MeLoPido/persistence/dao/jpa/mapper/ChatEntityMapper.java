package com.fpmislata.MeLoPido.persistence.dao.jpa.mapper;

import com.fpmislata.MeLoPido.domain.model.Chat;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.ChatEntity;

public class ChatEntityMapper {
    public static ChatEntity toChatEntity(Chat chat){
        ChatEntity chatEntity = new ChatEntity();
        chatEntity.setIdChat(chat.getIdChat());
        chatEntity.setCreationDate(chat.getCreationDate());
        chatEntity.setMessages(MessageEntityMapper.toMessageEntityList(chat.getMessages()));
        //TODO: como se añade el producto?
        return chatEntity;
    }

    public static Chat toChat(ChatEntity chatEntity){
        Chat chat = new Chat();
        chat.setIdChat(chatEntity.getIdChat());
        chat.setCreationDate(chatEntity.getCreationDate());
        chat.setMessages(MessageEntityMapper.toMessageList(chatEntity.getMessages()));
        return chat;
    }
}
