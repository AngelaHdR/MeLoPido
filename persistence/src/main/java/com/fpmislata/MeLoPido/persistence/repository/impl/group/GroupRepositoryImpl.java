package com.fpmislata.MeLoPido.persistence.repository.impl.group;

import com.fpmislata.MeLoPido.domain.model.Group;
import com.fpmislata.MeLoPido.domain.repository.GroupRepository;
import com.fpmislata.MeLoPido.persistence.dao.jpa.repository.GroupJpaRepository;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.Optional;

public class GroupRepositoryImpl implements GroupRepository {
    private GroupJpaRepository groupJpaRepository;
    @Override
    public ListWithCount<Group> findAllByUser(int page, int pageSize, String idUser) {
        return null;
    }

    @Override
    public ListWithCount<Group> findAll(int page, int pageSize) {
        return null;
    }

    @Override
    public Optional<Group> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void save(Group group) {

    }

    @Override
    public void delete(String id) {

    }
}
