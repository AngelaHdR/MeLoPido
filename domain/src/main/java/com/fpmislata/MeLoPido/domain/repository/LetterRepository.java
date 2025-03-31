package com.fpmislata.MeLoPido.domain.repository;

import com.fpmislata.MeLoPido.domain.model.Letter;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;


public interface LetterRepository {
    ListWithCount<Letter> findAll(int page, int pageSize);
    ListWithCount<Letter> findAllByUser(int page, int pageSize, String idUser);
    ListWithCount<Letter> findAllByGroup(int page, int pageSize, String idGroup);
    Letter findById(String idLetter);
    void save(Letter letter);
    void delete(String idLetter);
}
