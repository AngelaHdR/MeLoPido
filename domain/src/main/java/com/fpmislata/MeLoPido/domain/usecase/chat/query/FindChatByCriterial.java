package com.fpmislata.MeLoPido.domain.usecase.chat.query;

import com.fpmislata.MeLoPido.domain.usecase.model.query.ChatQuery;

public interface FindChatByCriterial {
    ChatQuery findById(String idChat);
    ChatQuery findByProductId(String idProduct);
}
