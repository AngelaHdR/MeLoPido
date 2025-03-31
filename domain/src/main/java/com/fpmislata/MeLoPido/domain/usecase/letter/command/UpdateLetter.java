package com.fpmislata.MeLoPido.domain.usecase.letter.command;

import com.fpmislata.MeLoPido.domain.usecase.model.command.LetterCommand;

public interface UpdateLetter {
    void update(String idLetter, LetterCommand letter);
    void sendToGroup(String idLetter, String idGroup, String expirationDate);
}
