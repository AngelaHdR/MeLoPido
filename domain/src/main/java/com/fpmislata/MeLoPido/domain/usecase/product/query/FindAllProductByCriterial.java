package com.fpmislata.MeLoPido.domain.usecase.product.query;

import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import com.fpmislata.MeLoPido.domain.usecase.model.query.ProductBasicQuery;


public interface FindAllProductByCriterial {
    ListWithCount<ProductBasicQuery> findAll(int page, int pageSize);
    ListWithCount<ProductBasicQuery> findAllAssignedToUser(int page, int pageSize, String idUser);
}
