package com.fpmislata.MeLoPido.persistence.repository.impl.product;

import com.fpmislata.MeLoPido.domain.model.Product;
import com.fpmislata.MeLoPido.domain.repository.ProductRepository;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.ProductEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.mapper.ProductEntityMapper;
import com.fpmislata.MeLoPido.persistence.dao.jpa.repository.ProductJpaRepository;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {
    private ProductJpaRepository productJpaRepository;

    public ProductRepositoryImpl(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public ListWithCount<Product> findAllAssignedToUser(int page, int pageSize, String idUser) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<ProductEntity> pages = productJpaRepository.findAllAssignedToUser(idUser, pageable);
        return new ListWithCount<>(pages.stream().map(ProductEntityMapper::toProduct).toList(), pages.getTotalElements());
    }

    @Override
    public ListWithCount<Product> findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<ProductEntity> pages = productJpaRepository.findAll(pageable);
        return new ListWithCount<>(pages.stream().map(ProductEntityMapper::toProduct).toList(), pages.getTotalElements());
    }

    @Override
    public Optional<Product> findById(String id) {
        return productJpaRepository.findById(id).map(ProductEntityMapper::toProduct);
    }

    @Override
    public void save(Product product) {
        productJpaRepository.save(ProductEntityMapper.toProductEntity(product));
    }

    @Override
    public void delete(String id) {
        productJpaRepository.deleteById(id);
    }
}
