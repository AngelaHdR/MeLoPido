package com.fpmislata.MeLoPido.domain.repository;

import com.fpmislata.MeLoPido.domain.model.Letter;
import com.fpmislata.MeLoPido.util.pagination.Page;

public interface LetterRepository {
    Page<Letter> findAll(int page, int pageSize);
    Page<Letter> findAllByUser(int page, int pageSize, Integer idUser);
    Page<Letter> findAllByGroup(int page, int pageSize, Integer idGroup);
    Letter findById(Integer idLetter);
    void save(Letter letter);
    void delete(Integer idLetter);
}
