package com.fpmislata.MeLoPido.domain.usecase.model.mapper;

import com.fpmislata.MeLoPido.domain.model.Product;
import com.fpmislata.MeLoPido.domain.usecase.model.command.ProductCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.ProductBasicQuery;

import java.util.List;

public class ProductQueryMapper {
    public static List<ProductBasicQuery> toProductCollectionQueryList(List<Product> products){
        if(products == null){
            return null;
        }
        return products.stream().map(ProductQueryMapper::toProductCollectionQuery).toList();
    }
    public static ProductBasicQuery toProductCollectionQuery(Product product){
        return new ProductBasicQuery(
                product.getIdProduct(),
                product.getName(),
                product.getDetail(),
                product.getUrl(),
                UserQueryMapper.toUserCollectionQuery(product.getAsignado())
        );
    }
    public static List<String> toProductNameCollection(List<Product> products){
        if(products == null){
            return null;
        }
        return products.stream().map(ProductQueryMapper::toProductName).toList();
    }

    public static String toProductName(Product product){
        return product.getName();
    }

    public static Product toProduct(ProductCommand productCommand){
        return new Product(
                productCommand.idProduct(),
                productCommand.name(),
                productCommand.detail(),
                productCommand.url()
        );
    }

    public static List<Product> toProductList(List<ProductCommand> productCommands){
        if(productCommands == null){
            return null;
        }
        return productCommands.stream().map(ProductQueryMapper::toProduct).toList();
    }
}
