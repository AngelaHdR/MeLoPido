package com.fpmislata.MeLoPido.api.webModel.command;

import java.util.List;

public record LetterRequest(
        String idLetter,
        String description,
        String idUser,
        String creationDate,
        List<ProductRequest> products
) {
}
