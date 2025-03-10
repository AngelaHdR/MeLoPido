package com.fpmislata.MeLoPido.domain.usecase.model.query;

public record ProductBasicQuery(
        Integer idProduct,
        String name,
        String detail,
        String url,
        UserBasicQuery asignado
){
}
