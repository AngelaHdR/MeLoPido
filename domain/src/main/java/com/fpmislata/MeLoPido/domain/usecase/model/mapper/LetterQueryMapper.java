package com.fpmislata.MeLoPido.domain.usecase.model.mapper;

import com.fpmislata.MeLoPido.domain.model.User;
import com.fpmislata.MeLoPido.domain.usecase.model.command.LetterCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterQuery;
import com.fpmislata.MeLoPido.domain.model.Letter;

public class LetterQueryMapper {
    public static LetterQuery toLetterQuery(Letter letter) {
        if (letter == null) {
            return null;
        }
        return new LetterQuery(
                letter.getIdLetter(),
                letter.getDescription(),
                letter.getCreationDate(),
                letter.getSendDate(),
                letter.getExpirationDate(),
                letter.getUser().getNameComplete(),
                letter.getGroup().getName(),
                ProductQueryMapper.toProductBasicQueryList(letter.getProducts())
        );
    }

    public static LetterBasicQuery toLetterBasicQuery(Letter letter) {
        if (letter == null) {
            return null;
        }
        return new LetterBasicQuery(
                letter.getIdLetter(),
                letter.getDescription(),
                letter.getUser().getNameComplete(),
                letter.getGroup().getName()
        );
    }

    public static Letter toLetter(LetterCommand letterCommand) {
        if (letterCommand == null) {
            return null;
        }
        return new Letter(
                letterCommand.idLetter(),
                letterCommand.description(),
                letterCommand.creationDate(),
                new User(letterCommand.idUser()),
                ProductQueryMapper.toProductList(letterCommand.products())
        );
    }
}
