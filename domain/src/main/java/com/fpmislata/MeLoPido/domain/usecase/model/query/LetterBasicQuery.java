package com.fpmislata.MeLoPido.domain.usecase.model.query;

public class LetterBasicQuery {
    String idLetter;
    String userName;
    String groupName;

    public LetterBasicQuery(String idLetter, String userName, String groupName) {
        this.idLetter = idLetter;
        this.userName = userName;
        this.groupName = groupName;
    }

    public String getIdLetter() {
        return idLetter;
    }

    public String getUserName() {
        return userName;
    }

    public String getGroupName() {
        return groupName;
    }
}
