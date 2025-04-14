package com.fpmislata.MeLoPido.persistence.repository.impl.product;

import com.fpmislata.MeLoPido.domain.model.Product;
import com.fpmislata.MeLoPido.domain.repository.ProductRepository;
import com.fpmislata.MeLoPido.persistence.dao.jpa.repository.ProductJpaRepository;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {
    private ProductJpaRepository productJpaRepository;
    @Override
    public ListWithCount<Product> findAllAssignedToUser(int page, int pageSize, String idUser) {
        return null;
    }

    @Override
    public ListWithCount<Product> findAll(int page, int pageSize) {
        return null;
    }

    @Override
    public Optional<Product> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(String id) {

    }
}
