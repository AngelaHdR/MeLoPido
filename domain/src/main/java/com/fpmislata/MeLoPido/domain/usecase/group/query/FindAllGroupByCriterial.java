package com.fpmislata.MeLoPido.domain.usecase.group.query;

import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupBasicQuery;

public interface FindAllGroupByCriterial {
    ListWithCount<GroupBasicQuery> findAll(int page, int pageSize);
    ListWithCount<GroupBasicQuery> findAllByUser(int page, int pageSize, String idUser);
}
