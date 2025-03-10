package com.fpmislata.MeLoPido.domain.usecase.model.query;

import java.util.List;

public record UserQuery(
        Integer idUser,
        String nameComplete,
        String email,
        String birthDate,
        List<LetterBasicQuery> letters,
        List<ProductBasicQuery> products
) {
}
