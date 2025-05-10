package com.fpmislata.MeLoPido.api.container;

import com.fpmislata.MeLoPido.domain.repository.ChatRepository;
import com.fpmislata.MeLoPido.domain.service.chat.ChatCommandService;
import com.fpmislata.MeLoPido.domain.service.chat.ChatQueryService;
import com.fpmislata.MeLoPido.domain.usecase.chat.command.DeleteChat;
import com.fpmislata.MeLoPido.domain.usecase.chat.command.UpdateChat;
import com.fpmislata.MeLoPido.domain.usecase.chat.query.FindAllChatByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.chat.query.FindChatByCriterial;
import com.fpmislata.MeLoPido.persistence.dao.jpa.repository.ChatJpaRepository;
import com.fpmislata.MeLoPido.persistence.repository.impl.chat.ChatRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

public class ChatIoC {
    private static ChatQueryService chatQueryService = new ChatQueryService(getChatRepository());
    private static ChatCommandService chatCommandService = new ChatCommandService(getChatRepository());

    private static ChatRepository chatRepository;

    public static FindAllChatByCriterial getFindAllChatByCriterial() {
        return chatQueryService;
    }

    public static FindChatByCriterial getFindChatByCriterial() {
        return chatQueryService;
    }

    public static DeleteChat getDeleteChat() {
        return chatCommandService;
    }

    public static UpdateChat getUpdateChat() {
        return chatCommandService;
    }

    public static ChatRepository getChatRepository() {
        if (chatRepository == null) {
            chatRepository = new ChatRepositoryImpl(getChatJpaRepository());
        }
        return chatRepository;
    }

    public static ChatJpaRepository getChatJpaRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meLoPidoUnit");
        EntityManager em = emf.createEntityManager();

        JpaRepositoryFactory factory = new JpaRepositoryFactory(em);
        return factory.getRepository(ChatJpaRepository.class);
    }

    public static void setChatQueryService(ChatQueryService chatService) {
        ChatIoC.chatQueryService = chatService;
    }

    public static void setChatCommandService(ChatCommandService chatCommandService) {
        ChatIoC.chatCommandService = chatCommandService;
    }

    public static void setChatRepository(ChatRepository chatRepository) {
        ChatIoC.chatRepository = chatRepository;
    }

    public static void reset() {
        chatQueryService = null;
        chatCommandService = null;
        chatRepository = null;
    }
}
