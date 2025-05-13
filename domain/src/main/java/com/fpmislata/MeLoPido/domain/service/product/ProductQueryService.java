package com.fpmislata.MeLoPido.domain.service.product;

import com.fpmislata.MeLoPido.domain.model.Product;
import com.fpmislata.MeLoPido.domain.model.User;
import com.fpmislata.MeLoPido.domain.repository.ProductRepository;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.ProductQueryMapper;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.UserQueryMapper;
import com.fpmislata.MeLoPido.domain.usecase.model.query.ProductBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.product.query.FindAllProductByCriterial;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.List;

public class ProductQueryService implements FindAllProductByCriterial {
    private final ProductRepository productRepository;
    public ProductQueryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public ListWithCount<ProductBasicQuery> findAll(int page, int pageSize) {
        ListWithCount<Product> productList = productRepository.findAll(page, pageSize);
        return new ListWithCount<>(ProductQueryMapper.toProductBasicQueryList(productList.getList()), productList.getCount());
    }

    @Override
    public ListWithCount<ProductBasicQuery> findAllAssignedToUser(int page, int pageSize, String idUser) {
        ListWithCount<Product> productList = productRepository.findAllAssignedToUser(page, pageSize, idUser);
        List<ProductBasicQuery> products = ProductQueryMapper.toProductBasicQueryList(productList.getList());
        return new ListWithCount<>(products, productList.getCount());
    }
}
