package com.fpmislata.MeLoPido.api.webModel.query;

import java.util.List;

public record UserDetailResponse (
        String idUser,
        String nameComplete,
        String email,
        String birthDate,
        List<GroupBasicResponse> groups,
        String username,
        String password,
        List<LetterBasicResponse> letters,
        List<ProductBasicResponse> products
) {
}