package com.fpmislata.MeLoPido.api.webModel.command;

public record GroupRequest(
        String idGroup,
        String name,
        String icon,
        String theme,
        String description
){
}
