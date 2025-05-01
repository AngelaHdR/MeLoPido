package com.fpmislata.MeLoPido.domain.usecase.letter.query;

import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterBasicQuery;


public interface FindAllLetterByCriterial {
    ListWithCount<LetterBasicQuery> findAll(int page, int pageSize);
    ListWithCount<LetterBasicQuery> findAllByUser(int page, int pageSize, String idUser);
    ListWithCount<LetterBasicQuery> findAllByGroup(int page, int pageSize, String idGroup);
}
