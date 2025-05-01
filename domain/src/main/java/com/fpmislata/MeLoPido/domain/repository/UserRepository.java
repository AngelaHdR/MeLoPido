package com.fpmislata.MeLoPido.domain.repository;

import com.fpmislata.MeLoPido.domain.model.User;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.Optional;

public interface UserRepository extends GenericRepository<User> {
    ListWithCount<User> findAllByGroup(int page, int pageSize, String idGroup);

    Optional<User> findByProductId(String idProduct);
}
