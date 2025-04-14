package com.fpmislata.MeLoPido.api.container;

import com.fpmislata.MeLoPido.domain.repository.ProductRepository;
import com.fpmislata.MeLoPido.domain.service.product.ProductQueryService;
import com.fpmislata.MeLoPido.domain.usecase.product.query.FindAllProductByCriterial;
import com.fpmislata.MeLoPido.persistence.repository.impl.product.ProductRepositoryImpl;

public class ProductIoC {
    private static ProductQueryService productQueryService = new ProductQueryService(getProductRepository());

    private static ProductRepository productRepository;

    public static FindAllProductByCriterial getFindAllProductByCriterial() {
        return productQueryService;
    }

    public static ProductRepository getProductRepository() {
        if (productRepository == null) {
            productRepository = new ProductRepositoryImpl();
        }
        return productRepository;
    }

    public static void setProductQueryService(ProductQueryService productService) {
        ProductIoC.productQueryService = productService;
    }

    public static void setProductRepository(ProductRepository productRepository) {
        ProductIoC.productRepository = productRepository;
    }

    public static void reset() {
        productQueryService = null;
        productRepository = null;
    }
}
