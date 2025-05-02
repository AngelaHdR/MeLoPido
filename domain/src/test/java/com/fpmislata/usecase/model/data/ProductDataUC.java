package com.fpmislata.usecase.model.data;

import com.fpmislata.MeLoPido.domain.usecase.model.command.ProductCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.ProductBasicQuery;

import java.util.List;

public class ProductDataUC {
    private static final List<ProductBasicQuery> productsBasicQuery = List.of(
            new ProductBasicQuery("1", "Product 1", "Detail 1", "URL 1", "available", UserDataUC.getUsersBasicQuery().get(0),"1"),
            new ProductBasicQuery("2", "Product 2", "Detail 2", "URL 2", "available", UserDataUC.getUsersBasicQuery().get(1),"2"),
            new ProductBasicQuery("3", "Product 3", "Detail 3", "URL 3", "available", UserDataUC.getUsersBasicQuery().get(2),"3")
    );

    private static final List<ProductCommand> productCommand = List.of(
            new ProductCommand("1", "Product 1", "Detail 1", "available", "URL 1"),
            new ProductCommand("2", "Product 2", "Detail 2", "available", "URL 2"),
            new ProductCommand("3", "Product 3", "Detail 3", "available","URL 3")
    );

    public static List<ProductBasicQuery> getProductsBasicQuery(){
        return productsBasicQuery;
    }

    public static List<ProductCommand> getProductsCommand(){
        return productCommand;
    }
}
