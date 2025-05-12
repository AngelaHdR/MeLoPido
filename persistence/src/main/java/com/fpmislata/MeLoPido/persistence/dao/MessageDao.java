package com.fpmislata.MeLoPido.persistence.dao;

import com.fpmislata.MeLoPido.domain.model.Message;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

public interface MessageDao extends GenericDao<Message> {
    ListWithCount<Message> findAllByChat(int page, int pageSize, String idChat);
}
