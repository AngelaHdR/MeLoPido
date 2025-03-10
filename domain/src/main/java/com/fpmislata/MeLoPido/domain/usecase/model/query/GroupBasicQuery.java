package com.fpmislata.MeLoPido.domain.usecase.model.query;

import java.util.List;

public record GroupBasicQuery(
        Integer idGroup,
        String name,
        String icon,
        List<String> users
) {
}
