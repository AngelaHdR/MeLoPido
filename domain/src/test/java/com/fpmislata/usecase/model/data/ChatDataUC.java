package com.fpmislata.usecase.model.data;

import com.fpmislata.MeLoPido.domain.usecase.model.query.ChatQuery;

import java.util.List;

public class ChatDataUC {
    private static final List<ChatQuery> chatsQuery = List.of(
            new ChatQuery("1", MessageDataUC.getMessagesBasicQuery()),
            new ChatQuery("2", MessageDataUC.getMessagesBasicQuery()),
            new ChatQuery("3", MessageDataUC.getMessagesBasicQuery())
    );

    public static List<ChatQuery> getChatsQuery() {
        return chatsQuery;
    }
}
