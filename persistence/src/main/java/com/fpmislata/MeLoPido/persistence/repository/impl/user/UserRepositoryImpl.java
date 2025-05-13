package com.fpmislata.MeLoPido.persistence.repository.impl.user;

import com.fpmislata.MeLoPido.domain.model.User;
import com.fpmislata.MeLoPido.domain.repository.UserRepository;
import com.fpmislata.MeLoPido.persistence.dao.UserDao;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.UserEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.mapper.UserEntityMapper;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private UserDao userDao;

    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public ListWithCount<User> findAllByGroup(int page, int pageSize, String idGroup) {
        ListWithCount<UserEntity> list = userDao.findAllByGroup(page, pageSize, idGroup);
        return new ListWithCount<>(list.getList().stream().map(UserEntityMapper::toUser).toList(), list.getCount());
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userDao.findByUsername(username).map(UserEntityMapper::toUser);
    }

    @Override
    public Optional<User> findByProductId(String idProduct) {
        return userDao.findByProductId(idProduct).map(UserEntityMapper::toUser);
    }

    @Override
    public ListWithCount<User> findAll(int page, int pageSize) {
        ListWithCount<UserEntity> list = userDao.findAll(page, pageSize);
        return new ListWithCount<>(list.getList().stream().map(UserEntityMapper::toUser).toList(), list.getCount());
    }

    @Override
    public Optional<User> findById(String id) {
        return userDao.findById(id).map(UserEntityMapper::toUser);
    }

    @Override
    public void save(User user) {
        userDao.save(UserEntityMapper.toUserEntity(user));
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
    }
}
