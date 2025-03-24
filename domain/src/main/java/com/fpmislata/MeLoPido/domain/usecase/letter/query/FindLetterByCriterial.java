package com.fpmislata.MeLoPido.domain.usecase.letter.query;

import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterQuery;

public interface FindLetterByCriterial {
    LetterQuery findById(String idLetter);
}
