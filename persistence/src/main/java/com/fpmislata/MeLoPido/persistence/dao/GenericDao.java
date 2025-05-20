package com.fpmislata.MeLoPido.persistence.dao;

import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import java.util.Optional;

public interface GenericDao<T>{
    ListWithCount<T> findAll(int page, int pageSize);
    Optional<T> findById(String id);
    String save(T t);
    void delete(String id);
}
