package com.fpmislata.MeLoPido.domain.usecase.model.query;

public record MessageBasicQuery(
        Integer idMessage,
        String sendDate,
        String content,
        UserBasicQuery sender
) {
}
