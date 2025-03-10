package com.fpmislata.MeLoPido.domain.usecase.model.command;

public record ProductCommand (
        Integer idProduct,
        String name,
        String detail,
        String url
) {
}
