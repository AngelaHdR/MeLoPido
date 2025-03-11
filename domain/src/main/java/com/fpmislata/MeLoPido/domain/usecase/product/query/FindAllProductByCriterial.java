package com.fpmislata.MeLoPido.domain.usecase.product.query;

import com.fpmislata.MeLoPido.domain.usecase.model.query.ProductBasicQuery;
import com.fpmislata.MeLoPido.util.pagination.Page;

public interface FindAllProductByCriterial {
    Page<ProductBasicQuery> findAll(int page, int pageSize);
    Page<ProductBasicQuery> findAllAssignedToUser(int page, int pageSize, Integer idUser);

}
