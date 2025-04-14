package com.fpmislata.MeLoPido.domain.repository;

import com.fpmislata.MeLoPido.domain.model.Chat;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.Optional;

public interface ChatRepository extends GenericRepository<Chat>{
    ListWithCount<Chat> findAllByUser(int page, int pageSize, String idUser);
    Optional<Chat> findByIdProduct(String idProduct);
}
