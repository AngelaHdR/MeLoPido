package com.fpmislata.MeLoPido.api.webModel.mapper;

import com.fpmislata.MeLoPido.api.webModel.command.ProductRequest;
import com.fpmislata.MeLoPido.api.webModel.query.ProductBasicResponse;
import com.fpmislata.MeLoPido.domain.usecase.model.command.ProductCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.ProductBasicQuery;

import java.util.List;

public class ProductWebModelMapper {
    public static ProductBasicResponse toProductBasicResponse(ProductBasicQuery productBasicQuery) {
        return new ProductBasicResponse(
                productBasicQuery.idProduct(),
                productBasicQuery.name(),
                productBasicQuery.detail(),
                productBasicQuery.url(),
                UserWebModelMapper.toUserBasicResponse(productBasicQuery.asignado())
        );
    }

    public static List<ProductBasicResponse> toProductBasicResponseList(List<ProductBasicQuery> productBasicQueryList) {
        return productBasicQueryList.stream().map(ProductWebModelMapper::toProductBasicResponse).toList();
    }

    public static ProductCommand toProductCommand(ProductRequest productRequest) {
        return new ProductCommand(
                productRequest.idProduct(),
                productRequest.name(),
                productRequest.detail(),
                productRequest.url()
        );
    }

    public static List<ProductCommand> toProductCommandList(List<ProductRequest> productRequestList) {
        return productRequestList.stream().map(ProductWebModelMapper::toProductCommand).toList();
    }
}
