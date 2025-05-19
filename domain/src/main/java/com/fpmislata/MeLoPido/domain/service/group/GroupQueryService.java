package com.fpmislata.MeLoPido.domain.service.group;

import com.fpmislata.MeLoPido.domain.model.Group;
import com.fpmislata.MeLoPido.domain.repository.GroupRepository;
import com.fpmislata.MeLoPido.domain.repository.LetterRepository;
import com.fpmislata.MeLoPido.domain.repository.UserRepository;
import com.fpmislata.MeLoPido.domain.usecase.group.query.FindAllGroupByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.group.query.FindGroupByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.GroupQueryMapper;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.LetterQueryMapper;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.UserQueryMapper;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.UserBasicQuery;
import com.fpmislata.MeLoPido.util.exception.PagedCollectionException;
import com.fpmislata.MeLoPido.util.exception.RessourceNotFoundException;
import com.fpmislata.MeLoPido.util.exception.UnauthorizedAccessException;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.util.List;

public class GroupQueryService implements FindAllGroupByCriterial, FindGroupByCriterial {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final LetterRepository letterRepository;
    private final String currentUser = "Ana Ortiz Gomez";
    private final List<String> currentGroup = List.of("Reyes Familia Ortiz");

    public GroupQueryService(GroupRepository groupRepository, UserRepository userRepository, LetterRepository letterRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.letterRepository = letterRepository;
    }

    @Override
    public ListWithCount<GroupBasicQuery> findAll(int page, int pageSize) {
        verifyPageAndSize(page, pageSize);
        ListWithCount<Group> groupList = groupRepository.findAll(page, pageSize);
        return new ListWithCount<>(groupList.getList().stream().map(GroupQueryMapper::toGroupBasicQuery).toList(), groupList.getCount());
    }

    @Override
    public ListWithCount<GroupBasicQuery> findAllByUser(int page, int pageSize, String idUser) {
        verifyPageAndSize(page, pageSize);

        ListWithCount<Group> groupList = groupRepository.findAllByUser(page, pageSize, idUser);
        return new ListWithCount<>(completeGroups(groupList.getList()), groupList.getCount());
    }
    private List<GroupBasicQuery> completeGroups(List<Group> groups){
        return groups.stream().map(group -> {
            GroupBasicQuery groupBasicQuery = GroupQueryMapper.toGroupBasicQuery(group);
            List<String> users = UserQueryMapper.toUserNameList(userRepository.findAllByGroup(0, 15, group.getIdGroup()).getList());
            groupBasicQuery.setUsers(users);
            return groupBasicQuery;
        }).toList();
    }
    @Override
    public GroupQuery findById(String idGroup) {
        GroupQuery groupQuery = GroupQueryMapper.toGroupQuery(groupRepository.findById(idGroup).orElseThrow(() -> new RessourceNotFoundException("Group not found")));
        //verifyAvailableGroup(groupQuery.getName());

        List<String> users = UserQueryMapper.toUserNameList(userRepository.findAllByGroup(0, 15, idGroup).getList());
        groupQuery.setUsers(users);

        List<LetterBasicQuery> letters = LetterQueryMapper.toLetterBasicQueryList(letterRepository.findAllByGroup(0, 15, idGroup).getList());
        groupQuery.setLetters(letters);

        return groupQuery;
    }

    private void verifyCurrentUser(String idUser) {
        System.out.println("user:"+idUser);
        if (!idUser.equals(currentUser)) {
            throw new UnauthorizedAccessException("User does not have the necessary permissions");
        }
    }

    private void verifyAvailableGroup(String idGroup) {
        System.out.println("group:"+idGroup);
        if (!currentGroup.contains(idGroup)) {
            throw new UnauthorizedAccessException("User does not have the necessary permissions");
        }
    }

    private void verifyCurrentUserOrGroup(String idUser, String idGroup) {
        System.out.println("user:"+idUser+"group:"+idGroup);
        if (!idUser.equals(currentUser) && !currentGroup.contains(idGroup)) {
            throw new UnauthorizedAccessException("User does not have the necessary permissions");
        }
    }

    private void verifyPageAndSize(int page, int pageSize) {
        if (page < 0 || pageSize <= 0) {
            throw new PagedCollectionException("Page number and size must be greater than 0");
        }
    }
}
