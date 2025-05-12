package com.fpmislata.MeLoPido.persistence.dao;

import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.ProductEntity;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

public interface ProductDao extends GenericDao<ProductEntity> {
    ListWithCount<ProductEntity> findAllAssignedToUser(int page, int pageSize, String idUser);
}
