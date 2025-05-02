package com.fpmislata.MeLoPido.persistence.dao.data;

import com.fpmislata.MeLoPido.domain.model.Product;

import java.util.List;

public class ProductData {
    private static final List<String> productsName = List.of(
            "Product 1",
            "Product 2",
            "Product 3"
    );
    private static final List<Product> products = List.of(
            new Product("1", "Product 1", "Detail 1", "URL 1", "available"),
            new Product("2", "Product 2", "Detail 2", "URL 2", "selected"),
            new Product("3", "Product 3", "Detail 3", "URL 3", "delivered")
    );

    public static List<String> getProductsName(){
        return productsName;
    }

    public static List<Product> getProducts(){
        return products;
    }
}
