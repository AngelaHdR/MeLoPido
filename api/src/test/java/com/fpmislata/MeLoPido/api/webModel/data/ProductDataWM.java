package com.fpmislata.MeLoPido.api.webModel.data;

import com.fpmislata.MeLoPido.api.webModel.command.ProductRequest;
import com.fpmislata.MeLoPido.api.webModel.query.ProductBasicResponse;

import java.util.List;

public class ProductDataWM {
    private static final List<ProductBasicResponse> productsBasicResponse = List.of(
            new ProductBasicResponse("1", "Product 1", "Detail 1", "URL 1", "available", UserDataWM.getUsersBasicResponse().get(0),"1"),
            new ProductBasicResponse("2", "Product 2", "Detail 2", "URL 2", "available", UserDataWM.getUsersBasicResponse().get(1),"2"),
            new ProductBasicResponse("3", "Product 3", "Detail 3", "URL 3", "available", UserDataWM.getUsersBasicResponse().get(2),"3")
    );

    private static final List<ProductRequest> productCommand = List.of(
            new ProductRequest("1", "Product 1", "Detail 1", "available", "URL 1"),
            new ProductRequest("2", "Product 2", "Detail 2", "available", "URL 2"),
            new ProductRequest("3", "Product 3", "Detail 3", "available","URL 3")
    );

    public static List<ProductBasicResponse> getProductsBasicResponse(){
        return productsBasicResponse;
    }

    public static List<ProductRequest> getProductsRequest(){
        return productCommand;
    }
}
