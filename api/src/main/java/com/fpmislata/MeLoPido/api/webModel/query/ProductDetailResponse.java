package com.fpmislata.MeLoPido.api.webModel.query;

public record ProductDetailResponse(
        String idProduct,
        String name,
        String detail,
        String url,
        String state,
        UserBasicResponse user,
        UserBasicResponse asignado,
        String chatLink
) {
}
