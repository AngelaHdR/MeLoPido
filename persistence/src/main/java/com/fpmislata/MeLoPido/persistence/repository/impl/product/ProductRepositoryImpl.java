package com.fpmislata.MeLoPido.persistence.repository.impl.product;

import com.fpmislata.MeLoPido.domain.model.Product;
import com.fpmislata.MeLoPido.domain.repository.ProductRepository;
import com.fpmislata.MeLoPido.persistence.dao.ProductDao;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.LetterEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.ProductEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.mapper.ProductEntityMapper;
import com.fpmislata.MeLoPido.util.exception.UnauthorizedAccessException;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {
    private ProductDao productDao;

    public ProductRepositoryImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public ListWithCount<Product> findAllAssignedToUser(int page, int pageSize, String idUser) {
        ListWithCount<ProductEntity> pages = productDao.findAllAssignedToUser(page, pageSize, idUser);
        return new ListWithCount<>(pages.getList().stream().map(ProductEntityMapper::toProduct).toList(), pages.getCount());
    }

    @Override
    public String save(Product product, String idLetter) {
        ProductEntity productEntity = ProductEntityMapper.toProductEntity(product);
        productEntity.setLetter(new LetterEntity(idLetter));
        return productDao.save(productEntity);
    }

    @Override
    public ListWithCount<Product> findAll(int page, int pageSize) {
        ListWithCount<ProductEntity> list = productDao.findAll(page, pageSize);
        return new ListWithCount<>(list.getList().stream().map(ProductEntityMapper::toProduct).toList(), list.getCount());
    }

    @Override
    public Optional<Product> findById(String id) {
        return productDao.findById(id).map(ProductEntityMapper::toProduct);
    }

    @Override
    public String save(Product product) {
        if (product.getIdProduct() == null) {
            throw new UnauthorizedAccessException("Product must be assigned to a letter");
        }
        ProductEntity productEntity = ProductEntityMapper.toProductEntity(product);
        return productDao.save(productEntity);
    }

    @Override
    public void delete(String id) {
        productDao.delete(id);
    }
}
