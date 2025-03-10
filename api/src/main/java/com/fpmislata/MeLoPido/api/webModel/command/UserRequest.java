package com.fpmislata.MeLoPido.api.webModel.command;

public record UserRequest(
        Integer idUser,
        String name,
        String surname1,
        String surname2,
        String email,
        String birthDate,
        String username,
        String password
) {
}
