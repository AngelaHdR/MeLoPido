package com.fpmislata.MeLoPido.persistence.dao;

import com.fpmislata.MeLoPido.domain.model.Chat;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.ChatEntity;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.Optional;

public interface ChatDao extends GenericDao<ChatEntity> {
    ListWithCount<ChatEntity> findAllByUser(int page, int pageSize, String idUser);
    Optional<ChatEntity> findByIdProduct(String idProduct);
}
