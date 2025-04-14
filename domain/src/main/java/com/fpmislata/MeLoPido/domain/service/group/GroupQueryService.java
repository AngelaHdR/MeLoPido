package com.fpmislata.MeLoPido.domain.service.group;

import com.fpmislata.MeLoPido.domain.repository.GroupRepository;
import com.fpmislata.MeLoPido.domain.usecase.group.query.FindAllGroupByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.group.query.FindGroupByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupQuery;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

public class GroupQueryService implements FindAllGroupByCriterial, FindGroupByCriterial {
    private final GroupRepository groupRepository;

    public GroupQueryService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public ListWithCount<GroupBasicQuery> findAll(int page, int pageSize) {
        return null;
    }

    @Override
    public ListWithCount<GroupBasicQuery> findAllByUser(int page, int pageSize, String idUser) {
        return null;
    }

    @Override
    public GroupQuery findById(String idGroup) {
        return null;
    }
}
