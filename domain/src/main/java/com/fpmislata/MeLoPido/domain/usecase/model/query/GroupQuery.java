package com.fpmislata.MeLoPido.domain.usecase.model.query;

import java.util.List;

public record GroupQuery (
        Integer idGroup,
        String name,
        String icon,
        List<UserBasicQuery> users,
        List<LetterBasicQuery> letters
) {
}