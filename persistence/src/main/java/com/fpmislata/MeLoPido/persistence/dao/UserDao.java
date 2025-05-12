package com.fpmislata.MeLoPido.persistence.dao;

import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.UserEntity;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.Optional;

public interface UserDao extends GenericDao<UserEntity> {
    ListWithCount<UserEntity> findAllByGroup(int page, int pageSize, String idGroup);
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByProductId(String idProduct);
}
