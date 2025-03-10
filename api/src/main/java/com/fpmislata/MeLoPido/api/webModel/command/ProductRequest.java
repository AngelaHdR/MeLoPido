package com.fpmislata.MeLoPido.api.webModel.command;

public record ProductRequest(
        Integer idProduct,
        String name,
        String detail,
        String url
) {
}
