package com.fpmislata.MeLoPido.domain.service.product;

import com.fpmislata.MeLoPido.domain.repository.ProductRepository;
import com.fpmislata.MeLoPido.domain.usecase.model.query.ProductBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.product.query.FindAllProductByCriterial;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

public class ProductQueryService implements FindAllProductByCriterial {
    private final ProductRepository productRepository;
    public ProductQueryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public ListWithCount<ProductBasicQuery> findAll(int page, int pageSize) {
        return null;
    }

    @Override
    public ListWithCount<ProductBasicQuery> findAllAssignedToUser(int page, int pageSize, String idUser) {
        return null;
    }
}
