package com.fpmislata.MeLoPido.domain.usecase.model.command;

import java.util.List;

public record LetterCommand (
        Integer idLetter,
        String description,
        Integer idUser,
        String creationDate,
        Integer idGroup,
        String sendDate,
        List<ProductCommand> products
) {
}
