package com.fpmislata.usecase.model.data;

import com.fpmislata.MeLoPido.domain.usecase.model.command.MessageCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.MessageBasicQuery;

import java.util.List;

public class MessageDataUC {
    private static final List<MessageBasicQuery> messagesBasicQuery = List.of(
            new MessageBasicQuery("1", "2021-01-01", "Hello, how are you?", UserDataUC.getUsersBasicQuery().get(0)),
            new MessageBasicQuery("2", "2021-01-02", "I'm fine, thank you!", UserDataUC.getUsersBasicQuery().get(0)),
            new MessageBasicQuery("3", "2021-01-03", "What about you?", UserDataUC.getUsersBasicQuery().get(0))
    );

    private static final List<MessageCommand> messagesCommand = List.of(
            new MessageCommand("1", "2021-01-01", "Hello, how are you?", "1"),
            new MessageCommand("2", "2021-01-02", "I'm fine, thank you!", "2"),
            new MessageCommand("3", "2021-01-03", "What about you?", "3")
    );

    public static List<MessageBasicQuery> getMessagesBasicQuery() {
        return messagesBasicQuery;
    }

    public static List<MessageCommand> getMessagesCommand() {
        return messagesCommand;
    }
}
