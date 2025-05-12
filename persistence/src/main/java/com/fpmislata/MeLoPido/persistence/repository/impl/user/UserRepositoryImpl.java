package com.fpmislata.MeLoPido.persistence.repository.impl.user;

import com.fpmislata.MeLoPido.domain.model.User;
import com.fpmislata.MeLoPido.domain.repository.UserRepository;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.UserEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.mapper.UserEntityMapper;
import com.fpmislata.MeLoPido.persistence.dao.jpa.repository.UserJpaRepository;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private UserJpaRepository userJpaRepository;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public ListWithCount<User> findAllByGroup(int page, int pageSize, String idGroup) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<UserEntity> pages = userJpaRepository.findAllByGroup(pageable, idGroup);
        return new ListWithCount<>(pages.stream().map(UserEntityMapper::toUser).toList(), pages.getTotalElements());
    }

    @Override
    public List<User> findByUsername(String username) {
        return userJpaRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByProductId(String idProduct) {
        return userJpaRepository.findByProductId(idProduct).map(UserEntityMapper::toUser);
    }

    @Override
    public ListWithCount<User> findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<UserEntity> pages = userJpaRepository.findAll(pageable);
        return new ListWithCount<>(pages.stream().map(UserEntityMapper::toUser).toList(), pages.getTotalElements());
    }

    @Override
    public Optional<User> findById(String id) {
        return userJpaRepository.findById(id).map(UserEntityMapper::toUser);
    }

    @Override
    public void save(User user) {
        userJpaRepository.save(UserEntityMapper.toUserEntity(user));
    }

    @Override
    public void delete(String id) {
        userJpaRepository.deleteById(id);
    }
}
