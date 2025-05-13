package com.fpmislata.MeLoPido.domain.usecase.letter.command;

public interface DeleteLetter {
    void delete(String idLetter);

    void removeFromGroup(String id, String idGroup);
}
