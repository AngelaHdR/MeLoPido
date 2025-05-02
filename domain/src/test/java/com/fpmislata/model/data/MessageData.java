package com.fpmislata.model.data;

import com.fpmislata.MeLoPido.domain.model.Message;

import java.util.List;

public class MessageData {
    private static final List<Message> messages = List.of(
            new Message("1", "2021-01-01","Hello, how are you?",  UserData.getUsers().get(0)),
            new Message("2", "2021-01-02","I'm fine, thank you!", UserData.getUsers().get(1)),
            new Message("3", "2021-01-03","What about you?", UserData.getUsers().get(2))
    );

    public static List<Message> getMessages(){
        return messages;
    }
}
