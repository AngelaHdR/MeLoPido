package com.fpmislata.MeLoPido.domain.usecase.model.command;

public record GroupCommand(
        Integer idGroup,
        String name,
        String icon,
        String theme,
        String description
) {
}
