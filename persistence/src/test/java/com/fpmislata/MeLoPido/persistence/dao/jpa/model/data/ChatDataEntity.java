package com.fpmislata.MeLoPido.persistence.dao.jpa.model.data;

import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.ChatEntity;

import java.util.List;

public class ChatDataEntity {
    private static final List<ChatEntity> chatsEntity = List.of(
            new ChatEntity("1", "2024-02-05", MessageDataEntity.getMessagesEntity()),
            new ChatEntity("2","2024-07-09", MessageDataEntity.getMessagesEntity()),
            new ChatEntity("3", "2024-08-15", MessageDataEntity.getMessagesEntity())
    );

    public static List<ChatEntity> getChatsEntity() {
        return chatsEntity;
    }
}
