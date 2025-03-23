package com.fpmislata.MeLoPido.api.webModel.query;

public record MessageBasicResponse(
        String idMessage,
        String sendDate,
        String content,
        UserBasicResponse sender
) {
}
