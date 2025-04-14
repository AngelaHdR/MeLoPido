package com.fpmislata.MeLoPido.persistence.repository.impl.user;

import com.fpmislata.MeLoPido.domain.model.User;
import com.fpmislata.MeLoPido.domain.repository.UserRepository;
import com.fpmislata.MeLoPido.persistence.dao.jpa.repository.UserJpaRepository;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private UserJpaRepository userJpaRepository;
    @Override
    public ListWithCount<User> findAllByGroup(int page, int pageSize, String idGroup) {
        return null;
    }

    @Override
    public Optional<User> findByProductId(String idProduct) {
        return Optional.empty();
    }

    @Override
    public ListWithCount<User> findAll(int page, int pageSize) {
        return null;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(String id) {

    }
}
