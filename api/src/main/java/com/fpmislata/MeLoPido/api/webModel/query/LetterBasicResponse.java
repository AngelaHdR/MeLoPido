package com.fpmislata.MeLoPido.api.webModel.query;

public record LetterBasicResponse(
        String idLetter,
        String description,
        String user,
        String group,
        String link
) {
}
