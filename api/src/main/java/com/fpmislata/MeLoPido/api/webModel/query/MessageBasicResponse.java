package com.fpmislata.MeLoPido.api.webModel.query;

public record MessageBasicResponse(
        Integer idMessage,
        String sendDate,
        String content,
        UserBasicResponse sender
) {
}
