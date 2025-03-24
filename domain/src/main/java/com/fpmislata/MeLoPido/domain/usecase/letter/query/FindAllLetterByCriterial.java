package com.fpmislata.MeLoPido.domain.usecase.letter.query;

import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterBasicQuery;
import com.fpmislata.MeLoPido.util.pagination.Page;

public interface FindAllLetterByCriterial {
    Page<LetterBasicQuery> findAll(int page, int pageSize);
    Page<LetterBasicQuery> findAllByUser(int page, int pageSize, String idUser);
    Page<LetterBasicQuery> findAllByGroup(int page, int pageSize, String idGroup);
}
