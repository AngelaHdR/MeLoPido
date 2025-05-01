package com.fpmislata.MeLoPido.api.webModel.query;

import java.util.List;

public record GroupDetailResponse(
        String idGroup,
        String name,
        String icon,
        String theme,
        String description,
        List<String> users,
        List<LetterBasicResponse> letters
) {
}
