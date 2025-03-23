package com.fpmislata.MeLoPido.domain.usecase.model.query;

public record ProductBasicQuery(
        String idProduct,
        String name,
        String detail,
        String url,
        UserBasicQuery asignado
){
}
