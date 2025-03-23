package com.fpmislata.MeLoPido.api.webModel.query;

import java.util.List;

public record LetterDetailResponse(
        String idLetter,
        String description,
        String user,
        String group,
        List<ProductBasicResponse> products
) {
}
