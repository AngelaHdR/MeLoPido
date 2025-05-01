package com.fpmislata.MeLoPido.domain.usecase.model.query;


import java.util.List;

public record LetterQuery(
        String idLetter,
        String description,
        String creationDate,
        String sendDate,
        String expirationDate,
        String user,
        String group,
        List<ProductBasicQuery> products
) {
}
