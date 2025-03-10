package com.fpmislata.MeLoPido.api.webModel.query;

import java.util.List;

public record UserDetailResponse (
        Integer idUser,
        String nameComplete,
        String email,
        String birthDate,
        List<LetterBasicResponse> letters,
        List<ProductBasicResponse> products
) {
}