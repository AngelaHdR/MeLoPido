package com.fpmislata.MeLoPido.api.webModel.command;

public record GroupRequest(
        Integer idGroup,
        String name,
        String icon,
        String theme,
        String description
){
}
