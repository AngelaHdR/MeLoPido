package com.fpmislata.MeLoPido.domain.usecase.user.command;

public interface DeleteUser {
    void delete(String idUser);
    void removeFromGroup(String idUser, String idGroup);
}
