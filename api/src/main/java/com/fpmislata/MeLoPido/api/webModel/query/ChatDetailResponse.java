package com.fpmislata.MeLoPido.api.webModel.query;

import java.util.List;

public record ChatDetailResponse(
        Integer idChat,
        List<MessageBasicResponse> messages
) {
}
