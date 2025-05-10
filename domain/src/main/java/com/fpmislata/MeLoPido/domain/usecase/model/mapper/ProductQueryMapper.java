package com.fpmislata.MeLoPido.domain.usecase.model.mapper;

import com.fpmislata.MeLoPido.domain.model.Product;
import com.fpmislata.MeLoPido.domain.usecase.model.command.ProductCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.ProductBasicQuery;

import java.util.List;

public class ProductQueryMapper {
    public static ProductBasicQuery toProductBasicQuery(Product product) {
        if (product == null) {
            return null;
        }
        String idChat = product.getChat() != null ? product.getChat().getIdChat() : null;
        return new ProductBasicQuery(
                product.getIdProduct(),
                product.getName(),
                product.getDetail(),
                product.getUrl(),
                product.getState(),
                UserQueryMapper.toUserBasicQuery(product.getAssigned()),
                idChat
        );
    }

    public static List<ProductBasicQuery> toProductBasicQueryList(List<Product> products) {
        if (products == null) {
            return null;
        }
        return products.stream().map(ProductQueryMapper::toProductBasicQuery).toList();
    }

    public static String toProductName(Product product) {
        if (product == null) {
            return null;
        }
        return product.getName();
    }

    public static List<String> toProductNameCollection(List<Product> products) {
        if (products == null) {
            return null;
        }
        return products.stream().map(ProductQueryMapper::toProductName).toList();
    }

    public static Product toProduct(ProductCommand productCommand) {
        return new Product(
                productCommand.idProduct(),
                productCommand.name(),
                productCommand.detail(),
                productCommand.url(),
                productCommand.state()
        );
    }

    public static List<Product> toProductList(List<ProductCommand> productCommands) {
        if (productCommands == null) {
            return null;
        }
        return productCommands.stream().map(ProductQueryMapper::toProduct).toList();
    }
}
