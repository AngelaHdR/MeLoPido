package com.fpmislata.MeLoPido.api.webModel.command;

public record MessageRequest(
        String idMessage,
        String sendDate,
        String content,
        String idUser
) {
}
