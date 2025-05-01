package com.fpmislata.MeLoPido.api.data;

import com.fpmislata.MeLoPido.domain.model.Chat;

import java.util.List;

public class ChatData {
    private static final List<Chat> chats = List.of(
            new Chat("1", "2021-01-01"),
            new Chat("2", "2021-02-01"),
            new Chat("3", "2021-03-01")
    );

    public static List<Chat> getChats() {
        return chats;
    }
}
