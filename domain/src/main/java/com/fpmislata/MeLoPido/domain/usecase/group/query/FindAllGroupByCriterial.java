package com.fpmislata.MeLoPido.domain.usecase.group.query;

import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupBasicQuery;
import com.fpmislata.MeLoPido.util.pagination.Page;

public interface FindAllGroupByCriterial {
    Page<GroupBasicQuery> findAll(int page, int pageSize);
    Page<GroupBasicQuery> findAllByUser(int page, int pageSize, Integer idUser);
}
