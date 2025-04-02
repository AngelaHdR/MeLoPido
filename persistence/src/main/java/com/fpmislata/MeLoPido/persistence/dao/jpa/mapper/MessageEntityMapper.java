package com.fpmislata.MeLoPido.persistence.dao.jpa.mapper;

import com.fpmislata.MeLoPido.domain.model.Message;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.MessageEntity;

import java.util.List;

public class MessageEntityMapper {
    public static Message toMessage(MessageEntity messageEntity){
        Message message = new Message();
        message.setIdMessage(messageEntity.getIdMessage());
        message.setContent(messageEntity.getContent());
        message.setSendDate(messageEntity.getSendDate());
        message.setSender(UserEntityMapper.toUser(messageEntity.getSender()));
        //TODO: como se añade el chat
        return message;
    }

    public static List<Message> toMessageList(List<MessageEntity> messageEntityList){
        return messageEntityList.stream().map(MessageEntityMapper::toMessage).toList();
    }

    public static MessageEntity toMessageEntity(Message message){
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setIdMessage(message.getIdMessage());
        messageEntity.setContent(message.getContent());
        messageEntity.setSendDate(message.getSendDate());
        messageEntity.setSender(UserEntityMapper.toUserEntity(message.getSender()));
        return messageEntity;
    }

    public static List<MessageEntity> toMessageEntityList(List<Message> messageList){
        return messageList.stream().map(MessageEntityMapper::toMessageEntity).toList();
    }
}
