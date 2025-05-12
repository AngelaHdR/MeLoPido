package com.fpmislata.MeLoPido.domain.service.group;

import com.fpmislata.MeLoPido.domain.model.Group;
import com.fpmislata.MeLoPido.domain.repository.GroupRepository;
import com.fpmislata.MeLoPido.domain.usecase.group.command.DeleteGroup;
import com.fpmislata.MeLoPido.domain.usecase.group.command.InsertGroup;
import com.fpmislata.MeLoPido.domain.usecase.group.command.UpdateGroup;
import com.fpmislata.MeLoPido.domain.usecase.model.command.GroupCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.GroupQueryMapper;
import com.fpmislata.MeLoPido.util.exception.RessourceNotFoundException;
import com.fpmislata.MeLoPido.util.exception.UnauthorizedAccessException;

import java.util.List;

public class GroupCommandService implements DeleteGroup, UpdateGroup, InsertGroup {
    private final GroupRepository groupRepository;
    private final List<String> currentGroup = List.of("1");

    public GroupCommandService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void deleteGroup(String groupId) {
        verifyAvailableGroup(groupId);
        groupRepository.delete(groupId);
    }

    @Override
    public void insert(GroupCommand group) {
        groupRepository.save(GroupQueryMapper.toGroup(group));
    }

    @Override
    public void update(String idGroup, GroupCommand group) {
        Group groupExisting = groupRepository.findById(idGroup).orElseThrow(() -> new RessourceNotFoundException("Group not found"));
        if(group.name() != null) {
            groupExisting.setName(group.name());
        }
        if(group.icon() != null) {
            groupExisting.setIcon(group.icon());
        }
        if(group.theme() != null) {
            groupExisting.setTheme(group.theme());
        }
        if(group.description() != null) {
            groupExisting.setDescription(group.description());
        }
        groupRepository.save(groupExisting);
    }

    private void verifyAvailableGroup(String idGroup) {
        if (!currentGroup.contains(idGroup)) {
            throw new UnauthorizedAccessException("User does not have the necessary permissions");
        }
    }
}
