package com.fpmislata.MeLoPido.domain.usecase.model.command;

public record MessageCommand (
        Integer idMessage,
        String sendDate,
        String content,
        Integer idUser
){
}
