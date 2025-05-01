package com.fpmislata.MeLoPido.api.webModel.mapper;

import com.fpmislata.MeLoPido.api.webModel.command.MessageRequest;
import com.fpmislata.MeLoPido.api.webModel.query.MessageBasicResponse;
import com.fpmislata.MeLoPido.domain.usecase.model.command.MessageCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.MessageBasicQuery;

import java.util.List;

public class MessageWebModelMapper {
    public static MessageBasicResponse toMessageBasicResponse(MessageBasicQuery messageQuery) {
        if (messageQuery == null) {
            return null;
        }
        return new MessageBasicResponse(
                messageQuery.idMessage(),
                messageQuery.sendDate(),
                messageQuery.content(),
                UserWebModelMapper.toUserBasicResponse(messageQuery.sender())
        );
    }

    public static List<MessageBasicResponse> toMessageBasicResponseList(List<MessageBasicQuery> messageQueryList) {
        if (messageQueryList == null) {
            return null;
        }
        return messageQueryList.stream().map(MessageWebModelMapper::toMessageBasicResponse).toList();
    }

    public static MessageCommand toMessageCommand(MessageRequest messageRequest) {
        if (messageRequest == null) {
            return null;
        }
        return new MessageCommand(
                messageRequest.idMessage(),
                messageRequest.sendDate(),
                messageRequest.content(),
                messageRequest.idUser()
        );
    }
}
