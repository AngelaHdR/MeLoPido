package com.fpmislata.MeLoPido.persistence.repository.impl.group;

import com.fpmislata.MeLoPido.domain.model.Group;
import com.fpmislata.MeLoPido.domain.repository.GroupRepository;
import com.fpmislata.MeLoPido.persistence.dao.GroupDao;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.GroupEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.mapper.GroupEntityMapper;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.Optional;

public class GroupRepositoryImpl implements GroupRepository {
    private GroupDao groupDao;

    public GroupRepositoryImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public ListWithCount<Group> findAllByUser(int page, int pageSize, String idUser) {
        ListWithCount<GroupEntity> list = groupDao.findAllByUser(page, pageSize, idUser);
        return new ListWithCount<>(list.getList().stream().map(GroupEntityMapper::toGroup).toList(), list.getCount());
    }

    @Override
    public ListWithCount<Group> findAll(int page, int pageSize) {
        ListWithCount<GroupEntity> list = groupDao.findAll(page, pageSize);
        return new ListWithCount<>(list.getList().stream().map(GroupEntityMapper::toGroup).toList(), list.getCount());
    }

    @Override
    public Optional<Group> findById(String id) {
        return groupDao.findById(id).map(GroupEntityMapper::toGroup);
    }

    @Override
    public String save(Group group) {
        return groupDao.save(GroupEntityMapper.toGroupEntity(group));
    }

    @Override
    public void delete(String id) {
        groupDao.delete(id);
    }
}
