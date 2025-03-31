package com.fpmislata.MeLoPido.domain.repository;

import com.fpmislata.MeLoPido.domain.model.Letter;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.Optional;


public interface LetterRepository extends GenericRepository<Letter> {
    ListWithCount<Letter> findAllByUser(int page, int pageSize, String idUser);
    ListWithCount<Letter> findAllByGroup(int page, int pageSize, String idGroup);
}
