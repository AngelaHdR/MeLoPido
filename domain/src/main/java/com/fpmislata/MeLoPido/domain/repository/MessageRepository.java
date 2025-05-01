package com.fpmislata.MeLoPido.domain.repository;

import com.fpmislata.MeLoPido.domain.model.Message;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

public interface MessageRepository extends GenericRepository<Message>{
    ListWithCount<Message> findAllByChat(int page, int pageSize, String idChat);
}
