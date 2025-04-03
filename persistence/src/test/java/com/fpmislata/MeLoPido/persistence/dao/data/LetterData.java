package com.fpmislata.MeLoPido.persistence.dao.data;

import com.fpmislata.MeLoPido.api.data.UserData;
import com.fpmislata.MeLoPido.domain.model.Letter;
import com.fpmislata.model.data.GroupData;

import java.util.List;

public class LetterData {
    private static final List<Letter> letters = List.of(
            new Letter("1", "Letter 1", "2021-01-01", "2021-01-02", "2021-06-02", UserData.getUsers().get(0), GroupData.getGroups().get(0), ProductData.getProducts()),
            new Letter("2", "Letter 2", "2021-02-01", "2021-02-02","2021-07-02", UserData.getUsers().get(1), GroupData.getGroups().get(1), ProductData.getProducts()),
            new Letter("3", "Letter 3", "2021-03-01", "2021-03-02","2021-08-02", UserData.getUsers().get(2), GroupData.getGroups().get(2), ProductData.getProducts())
    );

    public static List<Letter> getLetters() {
        return letters;
    }

}
