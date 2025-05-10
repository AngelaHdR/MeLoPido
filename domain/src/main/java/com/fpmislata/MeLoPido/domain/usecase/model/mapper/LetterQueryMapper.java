package com.fpmislata.MeLoPido.domain.usecase.model.mapper;

import com.fpmislata.MeLoPido.domain.model.User;
import com.fpmislata.MeLoPido.domain.usecase.model.command.LetterCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterQuery;
import com.fpmislata.MeLoPido.domain.model.Letter;

import java.util.List;

public class LetterQueryMapper {
    public static LetterQuery toLetterQuery(Letter letter) {
        if (letter == null) {
            return null;
        }
        String groupName = letter.getGroup() != null ? letter.getGroup().getName() : null;
        return new LetterQuery(
                letter.getIdLetter(),
                letter.getDescription(),
                letter.getCreationDate(),
                letter.getSendDate(),
                letter.getExpirationDate(),
                letter.getUser().getNameComplete(),
                groupName,
                ProductQueryMapper.toProductBasicQueryList(letter.getProducts())
        );
    }

    public static List<LetterQuery> toLetterQueryList(List<Letter> letters) {
        if (letters == null) {
            return null;
        }
        return letters.stream()
                .map(LetterQueryMapper::toLetterQuery)
                .toList();
    }

    public static LetterBasicQuery toLetterBasicQuery(Letter letter) {
        if (letter == null) {
            return null;
        }
        String groupName = letter.getGroup() != null ? letter.getGroup().getName() : null;
        return new LetterBasicQuery(
                letter.getIdLetter(),
                letter.getDescription(),
                letter.getUser().getNameComplete(),
                groupName
        );
    }

    public static List<LetterBasicQuery> toLetterBasicQueryList(List<Letter> letters) {
        if (letters == null) {
            return null;
        }
        return letters.stream()
                .map(LetterQueryMapper::toLetterBasicQuery)
                .toList();
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
