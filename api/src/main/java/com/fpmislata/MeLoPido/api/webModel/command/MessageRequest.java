package com.fpmislata.MeLoPido.api.webModel.command;

public record MessageRequest(
        Integer idMessage,
        String sendDate,
        String content,
        Integer idUser
) {
}
