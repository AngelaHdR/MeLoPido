package com.fpmislata.MeLoPido.api.webModel.query;

import java.util.List;

public record GroupBasicResponse(
        Integer idGroup,
        String name,
        String icon,
        List<String> users,
        String link
) {
}
