package com.fpmislata.MeLoPido.api.webModel.query;

import java.util.List;

public record ChatDetailResponse(
        String idChat,
        List<MessageBasicResponse> messages
) {
}
