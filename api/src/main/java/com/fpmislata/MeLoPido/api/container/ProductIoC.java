package com.fpmislata.MeLoPido.api.container;

import com.fpmislata.MeLoPido.domain.repository.ProductRepository;
import com.fpmislata.MeLoPido.domain.service.product.ProductQueryService;
import com.fpmislata.MeLoPido.domain.usecase.product.query.FindAllProductByCriterial;
import com.fpmislata.MeLoPido.persistence.dao.jpa.repository.ProductJpaRepository;
import com.fpmislata.MeLoPido.persistence.repository.impl.product.ProductRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

public class ProductIoC {
    private static ProductQueryService productQueryService = new ProductQueryService(getProductRepository());

    private static ProductRepository productRepository;

    public static FindAllProductByCriterial getFindAllProductByCriterial() {
        return productQueryService;
    }

    public static ProductRepository getProductRepository() {
        if (productRepository == null) {
            productRepository = new ProductRepositoryImpl(getProductJpaRepository());
        }
        return productRepository;
    }

    public static ProductJpaRepository getProductJpaRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meLoPidoUnit");
        EntityManager em = emf.createEntityManager();

        JpaRepositoryFactory factory = new JpaRepositoryFactory(em);
        return factory.getRepository(ProductJpaRepository.class);
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
