package com.fpmislata.MeLoPido.domain.repository;

import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.Optional;

public interface GenericRepository<T>{
    ListWithCount<T> findAll(int page, int pageSize);
    Optional<T> findById(String id);
    void save(T t);
    void delete(String id);
}
