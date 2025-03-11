package com.fpmislata.MeLoPido.domain.usecase.chat.query;

import com.fpmislata.MeLoPido.domain.model.Chat;
import com.fpmislata.MeLoPido.util.pagination.Page;

public interface FindAllChatByCriterial {
    Page<Chat> findAll(int page, int pageSize);
    Page<Chat> findAllByUser(int page, int pageSize, Integer idUser);
}
