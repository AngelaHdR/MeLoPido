package com.fpmislata.MeLoPido.domain.usecase.model.query;


import java.util.List;

public record LetterQuery(
        String idLetter,
        String description,
        String creationDate,
        String sendDate,
        String expirationDate,
        UserBasicQuery user,
        GroupBasicQuery group,
        List<ProductBasicQuery> products
) {
}
