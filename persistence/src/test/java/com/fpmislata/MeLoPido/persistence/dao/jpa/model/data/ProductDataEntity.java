package com.fpmislata.MeLoPido.persistence.dao.jpa.model.data;

import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.ProductEntity;

import java.util.List;

public class ProductDataEntity {
    private static final List<ProductEntity> productsEntity = List.of(
            new ProductEntity("1", "Product 1", "Detail 1", "URL 1", "available", LetterDataEntity.getLettersEntity().get(0), UserDataEntity.getUsersEntity().get(0), ChatDataEntity.getChatsEntity().get(0)),
            new ProductEntity("2", "Product 2", "Detail 2", "URL 2", "available", LetterDataEntity.getLettersEntity().get(1),UserDataEntity.getUsersEntity().get(1), ChatDataEntity.getChatsEntity().get(1)),
            new ProductEntity("3", "Product 3", "Detail 3", "URL 3", "available", LetterDataEntity.getLettersEntity().get(2),UserDataEntity.getUsersEntity().get(2), ChatDataEntity.getChatsEntity().get(2))
    );

    public static List<ProductEntity> getProductsEntity(){
        return productsEntity;
    }

}
