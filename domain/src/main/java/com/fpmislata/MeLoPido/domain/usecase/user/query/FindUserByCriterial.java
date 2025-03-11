package com.fpmislata.MeLoPido.domain.usecase.user.query;

import com.fpmislata.MeLoPido.domain.usecase.model.query.UserBasicQuery;

public interface FindUserByCriterial {
    UserBasicQuery findById(Integer idUser);
    UserBasicQuery findByProductId(Integer idProduct);
}
