package com.fpmislata.MeLoPido.api.webModel.query;

import java.util.List;

public record GroupDetailResponse(
        String idGroup,
        String name,
        String icon,
        List<UserBasicResponse> users,
        List<LetterBasicResponse> letters
) {
}
