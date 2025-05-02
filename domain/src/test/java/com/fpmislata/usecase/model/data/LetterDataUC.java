package com.fpmislata.usecase.model.data;

import com.fpmislata.MeLoPido.domain.usecase.model.command.LetterCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterQuery;
import com.fpmislata.model.data.UserData;
import com.fpmislata.model.data.GroupData;

import java.util.List;

public class LetterDataUC {

    private static final List<LetterQuery> lettersQuery = List.of(
            new LetterQuery("1", "Letter 1", "2021-01-01", "2021-01-02", "2021-06-02", UserData.getUsersName().get(0), GroupData.getGroupsName().get(0), ProductDataUC.getProductsBasicQuery()),
            new LetterQuery("2", "Letter 2", "2021-02-01", "2021-02-02", "2021-07-02", UserData.getUsersName().get(1), GroupData.getGroupsName().get(1), ProductDataUC.getProductsBasicQuery()),
            new LetterQuery("3", "Letter 3", "2021-03-01", "2021-03-02", "2021-08-02", UserData.getUsersName().get(2), GroupData.getGroupsName().get(2), ProductDataUC.getProductsBasicQuery())
    );

    private static final List<LetterBasicQuery> lettersBasicQuery = List.of(
            new LetterBasicQuery("1", "Letter 1", UserData.getUsersName().get(0), GroupData.getGroupsName().get(0)),
            new LetterBasicQuery("2", "Letter 2", UserData.getUsersName().get(1), GroupData.getGroupsName().get(1)),
            new LetterBasicQuery("3", "Letter 3", UserData.getUsersName().get(2), GroupData.getGroupsName().get(2))
    );

    private static final List<LetterCommand> lettersCommand = List.of(
            new LetterCommand("1", "Letter 1", UserData.getUsersName().get(0), "2021-01-01", ProductDataUC.getProductsCommand()),
            new LetterCommand("2", "Letter 2", UserData.getUsersName().get(1), "2021-02-01", ProductDataUC.getProductsCommand()),
            new LetterCommand("3", "Letter 3", UserData.getUsersName().get(2), "2021-03-01", ProductDataUC.getProductsCommand())
    );

    public static List<LetterQuery> getLettersQuery() {
        return lettersQuery;
    }

    public static List<LetterBasicQuery> getLettersBasicQuery() {
        return lettersBasicQuery;
    }

    public static List<LetterCommand> getLettersCommand() {
        return lettersCommand;
    }
}
