package com.fpmislata.MeLoPido.domain.usecase.model.command;

public record ProductCommand (
        String idProduct,
        String name,
        String detail,
        String state,
        String url
) {
}
