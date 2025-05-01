package com.fpmislata.MeLoPido.domain.usecase.user.query;

import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import com.fpmislata.MeLoPido.domain.usecase.model.query.UserBasicQuery;


public interface FindAllUserByCriterial {
    ListWithCount<UserBasicQuery> findAll(int page, int pageSize);
    ListWithCount<UserBasicQuery> findAllByGroup(int page, int pageSize, String idGroup);
}
