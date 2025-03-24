package com.fpmislata.MeLoPido.domain.usecase.user.query;

import com.fpmislata.MeLoPido.domain.usecase.model.query.UserBasicQuery;
import com.fpmislata.MeLoPido.util.pagination.Page;

public interface FindAllUserByCriterial {
    Page<UserBasicQuery> findAll(int page, int pageSize);
    Page<UserBasicQuery> findAllByGroup(int page, int pageSize, String idGroup);
}
