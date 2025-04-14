package com.fpmislata.MeLoPido.api.container;

import com.fpmislata.MeLoPido.domain.repository.LetterRepository;
import com.fpmislata.MeLoPido.domain.service.letter.LetterCommandService;
import com.fpmislata.MeLoPido.domain.service.letter.LetterQueryService;
import com.fpmislata.MeLoPido.domain.usecase.letter.command.DeleteLetter;
import com.fpmislata.MeLoPido.domain.usecase.letter.command.InsertLetter;
import com.fpmislata.MeLoPido.domain.usecase.letter.command.UpdateLetter;
import com.fpmislata.MeLoPido.domain.usecase.letter.query.FindAllLetterByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.letter.query.FindLetterByCriterial;
import com.fpmislata.MeLoPido.persistence.repository.impl.letter.LetterRepositoryImpl;

import static com.fpmislata.MeLoPido.api.container.ProductIoC.getProductRepository;

public class LetterIoC {
    //TODO: creacion de todos los IOC y inyectarlos unos con otros
    private static LetterQueryService letterQueryService = new LetterQueryService(getLetterRepository());
    private static LetterCommandService letterCommandService = new LetterCommandService(getLetterRepository(), getProductRepository());

    private static LetterRepository letterRepository;

    public static FindAllLetterByCriterial getFindAllLetterByCriterial() {
        return letterQueryService;
    }

    public static FindLetterByCriterial getFindLetterByCriterial() {
        return letterQueryService;
    }

    public static DeleteLetter getDeleteLetter() {
        return letterCommandService;
    }

    public static InsertLetter getInsertLetter() {
        return letterCommandService;
    }

    public static UpdateLetter getUpdateLetter() {
        return letterCommandService;
    }

    public static LetterRepository getLetterRepository() {
        if (letterRepository == null) {
            letterRepository = new LetterRepositoryImpl();
        }
        return letterRepository;
    }

    public static void setLetterQueryService(LetterQueryService letterService) {
        LetterIoC.letterQueryService = letterService;
    }

    public static void setLetterCommandService(LetterCommandService letterService) {
        LetterIoC.letterCommandService = letterService;
    }

    public static void setLetterRepository(LetterRepository letterRepository) {
        LetterIoC.letterRepository = letterRepository;
    }

    public static void reset() {
        letterQueryService = null;
        letterCommandService = null;
        letterRepository = null;
    }
}
