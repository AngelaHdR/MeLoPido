package com.fpmislata.MeLoPido.api.webModel.mapper;

import com.fpmislata.MeLoPido.api.webModel.command.ProductRequest;
import com.fpmislata.MeLoPido.api.webModel.query.ProductBasicResponse;
import com.fpmislata.MeLoPido.domain.usecase.model.command.ProductCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.ProductBasicQuery;

import java.util.List;

public class ProductWebModelMapper {
    public static ProductBasicResponse toProductBasicResponse(ProductBasicQuery productBasicQuery) {
        if (productBasicQuery == null) {
            return null;
        }
        return new ProductBasicResponse(
                productBasicQuery.idProduct(),
                productBasicQuery.name(),
                generateLink(productBasicQuery.idProduct())
        );
    }

    public static List<ProductBasicResponse> toProductBasicResponseList(List<ProductBasicQuery> productBasicQueryList) {
        if (productBasicQueryList == null) {
            return null;
        }
        return productBasicQueryList.stream().map(ProductWebModelMapper::toProductBasicResponse).toList();
    }

    public static ProductCommand toProductCommand(ProductRequest productRequest) {
        if (productRequest == null) {
            return null;
        }
        return new ProductCommand(
                productRequest.idProduct(),
                productRequest.name(),
                productRequest.detail(),
                productRequest.url(),
                productRequest.state()
        );
    }

    public static List<ProductCommand> toProductCommandList(List<ProductRequest> productRequestList) {
        if (productRequestList == null) {
            return null;
        }
        return productRequestList.stream().map(ProductWebModelMapper::toProductCommand).toList();
    }

    private static String generateLink(String idProduct) {
        return "http://localhost:8080/api/products/" + idProduct;
    }
}
