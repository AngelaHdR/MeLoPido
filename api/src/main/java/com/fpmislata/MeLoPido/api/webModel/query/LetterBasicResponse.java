package com.fpmislata.MeLoPido.api.webModel.query;

public record LetterBasicResponse(
        Integer idLetter,
        String description,
        String user,
        String group,
        String link
) {
}
