package com.fpmislata.MeLoPido.api.webModel.data;

import com.fpmislata.MeLoPido.api.webModel.query.ChatDetailResponse;

import java.util.List;

public class ChatDataWM {
    private static final List<ChatDetailResponse> chats = List.of(
            new ChatDetailResponse("1", MessageDataWM.getMessagesBasicResponse()),
            new ChatDetailResponse("2", MessageDataWM.getMessagesBasicResponse()),
            new ChatDetailResponse("3", MessageDataWM.getMessagesBasicResponse())
    );

    public static List<ChatDetailResponse> getChatsResponse() {
        return chats;
    }
}
