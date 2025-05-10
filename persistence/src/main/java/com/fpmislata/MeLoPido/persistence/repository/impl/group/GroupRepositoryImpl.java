package com.fpmislata.MeLoPido.persistence.repository.impl.group;

import com.fpmislata.MeLoPido.domain.model.Group;
import com.fpmislata.MeLoPido.domain.repository.GroupRepository;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.GroupEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.mapper.GroupEntityMapper;
import com.fpmislata.MeLoPido.persistence.dao.jpa.repository.GroupJpaRepository;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class GroupRepositoryImpl implements GroupRepository {
    private GroupJpaRepository groupJpaRepository;

    public GroupRepositoryImpl(GroupJpaRepository groupJpaRepository) {
        this.groupJpaRepository = groupJpaRepository;
    }

    @Override
    public ListWithCount<Group> findAllByUser(int page, int pageSize, String idUser) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<GroupEntity> pages = groupJpaRepository.findAllByUser(pageable, idUser);
        return new ListWithCount<>(pages.stream().map(GroupEntityMapper::toGroup).toList(), pages.getTotalElements());
    }

    @Override
    public ListWithCount<Group> findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<GroupEntity> pages = groupJpaRepository.findAll(pageable);
        return new ListWithCount<>(pages.stream().map(GroupEntityMapper::toGroup).toList(), pages.getTotalElements());
    }

    @Override
    public Optional<Group> findById(String id) {
        return groupJpaRepository.findById(id).map(GroupEntityMapper::toGroup);
    }

    @Override
    public void save(Group group) {
        groupJpaRepository.save(GroupEntityMapper.toGroupEntity(group));
    }

    @Override
    public void delete(String id) {
        groupJpaRepository.deleteById(id);
    }
}
