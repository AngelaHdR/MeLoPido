package com.fpmislata.MeLoPido.domain.usecase.chat.query;

import com.fpmislata.MeLoPido.domain.model.Chat;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;


public interface FindAllChatByCriterial {
    ListWithCount<Chat> findAll(int page, int pageSize);
    ListWithCount<Chat> findAllByUser(int page, int pageSize, String idUser);
}
