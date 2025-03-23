package com.fpmislata.MeLoPido.api.webModel.query;

import java.util.List;

public record UserDetailResponse (
        String idUser,
        String nameComplete,
        String email,
        String birthDate,
        String username,
        String password,
        List<LetterBasicResponse> letters,
        List<ProductBasicResponse> products
) {
}