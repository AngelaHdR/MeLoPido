package com.fpmislata.MeLoPido.domain.repository;

import com.fpmislata.MeLoPido.domain.model.Product;
import com.fpmislata.MeLoPido.domain.usecase.model.query.ProductBasicQuery;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends GenericRepository<Product> {
    ListWithCount<Product> findAllAssignedToUser(int page, int pageSize, String idUser);
    String save(Product product, String idLetter);
}
