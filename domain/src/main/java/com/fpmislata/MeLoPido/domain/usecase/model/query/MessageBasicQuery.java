package com.fpmislata.MeLoPido.domain.usecase.model.query;

public record MessageBasicQuery(
        String idMessage,
        String sendDate,
        String content,
        UserBasicQuery sender
) {
}
