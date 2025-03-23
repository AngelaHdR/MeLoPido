package com.fpmislata.MeLoPido.domain.usecase.model.mapper;

import com.fpmislata.MeLoPido.domain.model.Message;
import com.fpmislata.MeLoPido.domain.model.User;
import com.fpmislata.MeLoPido.domain.usecase.model.command.MessageCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.MessageBasicQuery;

import java.util.List;

public class MessageQueryMapper {
    public static MessageBasicQuery toMessageBasicQuery(Message message){
        if(message == null){
            return null;
        }
        return new MessageBasicQuery(
                message.getIdMessage(),
                message.getSendDate(),
                message.getContent(),
                UserQueryMapper.toUserBasicQuery(message.getSender())
        );
    }

    public static List<MessageBasicQuery> toMessageBasicQueryList(List<Message> messages){
        if(messages == null){
            return null;
        }
        return messages.stream().map(MessageQueryMapper::toMessageBasicQuery).toList();
    }

    public static Message toMessage(MessageCommand messageCommand){
        if(messageCommand == null){
            return null;
        }
        return new Message(
                messageCommand.idMessage(),
                messageCommand.sendDate(),
                messageCommand.content(),
                new User(messageCommand.idUser())
        );
    }
}
