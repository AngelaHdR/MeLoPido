package com.fpmislata.MeLoPido.api.webModel.query;

import java.util.List;

public record GroupDetailResponse(
        Integer idGroup,
        String name,
        String icon,
        List<UserBasicResponse> users,
        List<LetterBasicResponse> letters
) {
}
