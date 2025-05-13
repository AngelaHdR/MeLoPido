package com.fpmislata.MeLoPido.persistence.dao.jpa.mapper;

import com.fpmislata.MeLoPido.domain.model.Message;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.MessageEntity;

import java.util.List;

public class MessageEntityMapper {
    public static Message toMessage(MessageEntity messageEntity){
        if (messageEntity == null) {
            return null;
        }
        Message message = new Message();
        message.setIdMessage(messageEntity.getIdMessage());
        message.setContent(messageEntity.getContent());
        message.setSendDate(messageEntity.getSendDate());
        message.setSender(UserEntityMapper.toUser(messageEntity.getSender()));
        return message;
    }

    public static List<Message> toMessageList(List<MessageEntity> messageEntityList){
        if (messageEntityList == null) {
            return null;
        }
        return messageEntityList.stream().map(MessageEntityMapper::toMessage).toList();
    }

    public static MessageEntity toMessageEntity(Message message){
        if (message == null) {
            return null;
        }
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setIdMessage(message.getIdMessage());
        messageEntity.setContent(message.getContent());
        messageEntity.setSendDate(message.getSendDate());
        messageEntity.setSender(UserEntityMapper.toUserEntity(message.getSender()));
        return messageEntity;
    }

    public static List<MessageEntity> toMessageEntityList(List<Message> messageList){
        if (messageList == null) {
            return null;
        }
        return messageList.stream().map(MessageEntityMapper::toMessageEntity).toList();
    }
}
