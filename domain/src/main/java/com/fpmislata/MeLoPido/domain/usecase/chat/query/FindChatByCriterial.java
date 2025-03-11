package com.fpmislata.MeLoPido.domain.usecase.chat.query;

import com.fpmislata.MeLoPido.domain.usecase.model.query.ChatQuery;

public interface FindChatByCriterial {
    ChatQuery findById(Integer idChat);
    ChatQuery findByProductId(Integer idProduct);
}
