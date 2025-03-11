package com.fpmislata.MeLoPido.domain.usecase.group.query;

import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupQuery;

public interface FindGroupByCriterial {
    GroupQuery findById(Integer idGroup);
}
