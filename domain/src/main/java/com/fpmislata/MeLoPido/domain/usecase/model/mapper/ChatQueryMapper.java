package com.fpmislata.MeLoPido.domain.usecase.model.mapper;

import com.fpmislata.MeLoPido.domain.model.Chat;
import com.fpmislata.MeLoPido.domain.usecase.model.query.ChatQuery;

public class ChatQueryMapper {
    public static ChatQuery toChatQuery(Chat chat){
        if(chat == null){
            return null;
        }
        return new ChatQuery(
                chat.getIdChat(),
                MessageQueryMapper.toMessageBasicQueryList(chat.getMessages())
        );
    }


}
