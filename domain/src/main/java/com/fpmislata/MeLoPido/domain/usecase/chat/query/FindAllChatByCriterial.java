package com.fpmislata.MeLoPido.domain.usecase.chat.query;

import com.fpmislata.MeLoPido.domain.model.Chat;
import com.fpmislata.MeLoPido.domain.usecase.model.query.ChatQuery;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;


public interface FindAllChatByCriterial {
    ListWithCount<ChatQuery> findAll(int page, int pageSize);
    ListWithCount<ChatQuery> findAllByUser(int page, int pageSize, String idUser);
}
