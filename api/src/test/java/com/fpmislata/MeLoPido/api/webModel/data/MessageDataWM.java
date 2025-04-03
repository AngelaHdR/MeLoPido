package com.fpmislata.MeLoPido.api.webModel.data;

import com.fpmislata.MeLoPido.api.webModel.command.MessageRequest;
import com.fpmislata.MeLoPido.api.webModel.query.MessageBasicResponse;

import java.util.List;

public class MessageDataWM {
    private static final List<MessageBasicResponse> messages = List.of(
            new MessageBasicResponse("1", "2021-01-01", "Hello, how are you?", UserDataWM.getUsersBasicResponse().get(0)),
            new MessageBasicResponse("2", "2021-01-02", "I'm fine, thank you!", UserDataWM.getUsersBasicResponse().get(1)),
            new MessageBasicResponse("3", "2021-01-03", "What about you?", UserDataWM.getUsersBasicResponse().get(2))
    );

    private static final List<MessageRequest> messagesRequest = List.of(
            new MessageRequest("1", "2021-01-01", "Hello, how are you?", "1"),
            new MessageRequest("2", "2021-01-02", "I'm fine, thank you!", "2"),
            new MessageRequest("3", "2021-01-03", "What about you?", "3")
    );

    public static List<MessageBasicResponse> getMessagesBasicResponse() {
        return messages;
    }

    public static List<MessageRequest> getMessagesRequest() {
        return messagesRequest;
    }
}
