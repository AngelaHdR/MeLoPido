package com.fpmislata.MeLoPido.api.webModel.command;

public record ProductRequest(
        String idProduct,
        String name,
        String detail,
        String url,
        String state
) {
}
