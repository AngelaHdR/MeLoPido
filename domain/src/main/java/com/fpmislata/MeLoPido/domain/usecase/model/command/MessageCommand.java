package com.fpmislata.MeLoPido.domain.usecase.model.command;

public record MessageCommand (
        String idMessage,
        String sendDate,
        String content,
        String idUser
){
}
