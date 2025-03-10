package com.fpmislata.MeLoPido.domain.usecase.model.query;

public record LetterBasicQuery(
    Integer idLetter,
    String description,
    String user,
    String group
){
}
