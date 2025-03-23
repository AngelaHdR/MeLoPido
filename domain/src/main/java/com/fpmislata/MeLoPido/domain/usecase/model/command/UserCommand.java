package com.fpmislata.MeLoPido.domain.usecase.model.command;

public record UserCommand(
        String idUser,
        String name,
        String surname1,
        String surname2,
        String email,
        String birthDate,
        String username,
        String password
) {
}
