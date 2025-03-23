package com.fpmislata.MeLoPido.api.webModel.mapper;

import com.fpmislata.MeLoPido.api.webModel.query.ChatDetailResponse;
import com.fpmislata.MeLoPido.domain.usecase.model.query.ChatQuery;

public class ChatWebModelMapper {
    public static ChatDetailResponse toChatDetailResponse(ChatQuery chatQuery) {
        if (chatQuery == null) {
            return null;
        }
        return new ChatDetailResponse(
                chatQuery.idChat(),
                MessageWebModelMapper.toMessageBasicResponseList(chatQuery.messages())
        );
    }
}
