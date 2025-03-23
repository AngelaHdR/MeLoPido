package com.fpmislata.MeLoPido.api.webModel.query;

public record ProductBasicResponse(
        String idProduct,
        String name,
        String detail,
        String url,
        UserBasicResponse asignado
) {
}