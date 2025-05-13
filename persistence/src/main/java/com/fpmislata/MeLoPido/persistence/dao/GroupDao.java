package com.fpmislata.MeLoPido.persistence.dao;

import com.fpmislata.MeLoPido.domain.model.Group;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.GroupEntity;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

public interface GroupDao extends GenericDao<GroupEntity> {
    ListWithCount<GroupEntity> findAllByUser(int page, int pageSize, String idUser);
}
