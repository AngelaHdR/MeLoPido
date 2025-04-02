package com.fpmislata.MeLoPido.persistence.dao.jpa.mapper;

import com.fpmislata.MeLoPido.domain.model.Product;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.ProductEntity;

import java.util.List;

public class ProductEntityMapper {
    public static Product toProduct(ProductEntity productEntity){
        Product product = new Product();
        product.setIdProduct(productEntity.getIdProduct());
        product.setName(productEntity.getName());
        product.setDetail(productEntity.getDetail());
        product.setUrl(productEntity.getUrl());
        product.setState(productEntity.getState());
        product.setAsignado(UserEntityMapper.toUser(productEntity.getAsignado()));
        product.setChat(ChatEntityMapper.toChat(productEntity.getChat()));
        //TODO: como añadir letter?
        return product;
    }

    public static List<Product> toProductList(List<ProductEntity> productsEntityList){
        return productsEntityList.stream().map(ProductEntityMapper::toProduct).toList();
    }

    public static ProductEntity toProductEntity(Product product){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setIdProduct(product.getIdProduct());
        productEntity.setName(product.getName());
        productEntity.setDetail(product.getDetail());
        productEntity.setUrl(product.getUrl());
        productEntity.setState(product.getState());
        productEntity.setAsignado(UserEntityMapper.toUserEntity(product.getAsignado()));
        productEntity.setChat(ChatEntityMapper.toChatEntity(product.getChat()));
        return productEntity;
    }

    public static List<ProductEntity> toProductEntityList(List<Product> productsList){
        return productsList.stream().map(ProductEntityMapper::toProductEntity).toList();
    }
}
