package com.fpmislata.MeLoPido.domain.usecase.model.query;

import java.util.List;

public record ChatQuery(
        String idChat,
        List<MessageBasicQuery> messages
) {
}
