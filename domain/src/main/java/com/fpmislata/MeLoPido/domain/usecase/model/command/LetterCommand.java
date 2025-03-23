package com.fpmislata.MeLoPido.domain.usecase.model.command;

import java.util.List;

public record LetterCommand (
        String idLetter,
        String description,
        Integer idUser,
        String creationDate,
        List<ProductCommand> products
) {
}
