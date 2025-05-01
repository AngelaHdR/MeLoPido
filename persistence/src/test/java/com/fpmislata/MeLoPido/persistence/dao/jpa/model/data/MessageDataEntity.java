package com.fpmislata.MeLoPido.persistence.dao.jpa.model.data;

import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.MessageEntity;

import java.util.List;

public class MessageDataEntity {
    private static final List<MessageEntity> messagesEntity = List.of(
            new MessageEntity("1", "Hello!", "2021-01-01",  UserDataEntity.getUsersEntity().get(0),ChatDataEntity.getChatsEntity().get(0)),
            new MessageEntity("2", "How are you?", "2021-01-02", UserDataEntity.getUsersEntity().get(1),ChatDataEntity.getChatsEntity().get(0)),
            new MessageEntity("3", "Goodbye!", "2021-01-03", UserDataEntity.getUsersEntity().get(2),ChatDataEntity.getChatsEntity().get(0))
    );

    public static List<MessageEntity> getMessagesEntity() {
        return messagesEntity;
    }
}
