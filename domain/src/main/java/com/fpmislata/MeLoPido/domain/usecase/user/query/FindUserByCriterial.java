package com.fpmislata.MeLoPido.domain.usecase.user.query;

import com.fpmislata.MeLoPido.domain.usecase.model.query.UserQuery;

public interface FindUserByCriterial {
    UserQuery findById(String idUser);
    UserQuery findByProductId(String idProduct);
}
