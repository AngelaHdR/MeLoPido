package com.fpmislata.MeLoPido.api.container;

import com.fpmislata.MeLoPido.domain.repository.ChatRepository;
import com.fpmislata.MeLoPido.domain.service.chat.ChatQueryService;
import com.fpmislata.MeLoPido.domain.usecase.chat.query.FindAllChatByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.chat.query.FindChatByCriterial;
import com.fpmislata.MeLoPido.persistence.repository.impl.chat.ChatRepositoryImpl;

public class ChatIoC {
    private static ChatQueryService chatQueryService = new ChatQueryService(getChatRepository());

    private static ChatRepository chatRepository;

    public static FindAllChatByCriterial getFindAllChatByCriterial() {
        return chatQueryService;
    }

    public static FindChatByCriterial getFindChatByCriterial() {
        return chatQueryService;
    }

    public static ChatRepository getChatRepository() {
        if (chatRepository == null) {
            chatRepository = new ChatRepositoryImpl();
        }
        return chatRepository;
    }

    public static void setChatQueryService(ChatQueryService chatService) {
        ChatIoC.chatQueryService = chatService;
    }

    public static void setChatRepository(ChatRepository chatRepository) {
        ChatIoC.chatRepository = chatRepository;
    }

    public static void reset() {
        chatQueryService = null;
        chatRepository = null;
    }
}
