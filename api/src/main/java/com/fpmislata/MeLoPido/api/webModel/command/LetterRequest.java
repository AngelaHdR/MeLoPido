package com.fpmislata.MeLoPido.api.webModel.command;

import java.util.List;

public record LetterRequest(
        String idLetter,
        String description,
        Integer idUser,
        String creationDate,
        Integer idGroup,
        String sendDate,
        List<ProductRequest> products
) {
}
