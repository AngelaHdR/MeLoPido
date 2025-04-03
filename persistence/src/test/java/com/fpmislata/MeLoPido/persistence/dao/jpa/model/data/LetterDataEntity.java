package com.fpmislata.MeLoPido.persistence.dao.jpa.model.data;


import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.LetterEntity;

import java.util.List;

public class LetterDataEntity {

    private static final List<LetterEntity> lettersEntity = List.of(
            new LetterEntity("1", "Letter 1", "2021-01-01", "2021-01-02", "2021-06-02", UserDataEntity.getUsersEntity().get(0), GroupDataEntity.getGroupsEntity().get(0), ProductDataEntity.getProductsEntity()),
            new LetterEntity("2", "Letter 2", "2021-01-01", "2021-01-02", "2021-06-02", UserDataEntity.getUsersEntity().get(0), GroupDataEntity.getGroupsEntity().get(0), ProductDataEntity.getProductsEntity()),
            new LetterEntity("3", "Letter 3", "2021-01-01", "2021-01-02", "2021-06-02", UserDataEntity.getUsersEntity().get(0), GroupDataEntity.getGroupsEntity().get(0), ProductDataEntity.getProductsEntity())
    );


    public static List<LetterEntity> getLettersEntity() {
        return lettersEntity;
    }
}
