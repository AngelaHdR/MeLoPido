package com.fpmislata.MeLoPido.domain.service.group;

import com.fpmislata.MeLoPido.domain.repository.GroupRepository;
import com.fpmislata.MeLoPido.domain.usecase.group.command.DeleteGroup;
import com.fpmislata.MeLoPido.domain.usecase.group.command.InsertGroup;
import com.fpmislata.MeLoPido.domain.usecase.group.command.UpdateGroup;
import com.fpmislata.MeLoPido.domain.usecase.model.command.GroupCommand;

public class GroupCommandService implements DeleteGroup, UpdateGroup, InsertGroup {
    private final GroupRepository groupRepository;

    public GroupCommandService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void deleteGroup(String groupId) {

    }

    @Override
    public void insert(GroupCommand group) {

    }

    @Override
    public void update(String idGroup, GroupCommand group) {

    }
}
