package com.fpmislata.MeLoPido.domain.service.user;

import com.fpmislata.MeLoPido.domain.repository.UserRepository;
import com.fpmislata.MeLoPido.domain.usecase.model.command.UserCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.UserBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.user.command.DeleteUser;
import com.fpmislata.MeLoPido.domain.usecase.user.command.InsertUser;
import com.fpmislata.MeLoPido.domain.usecase.user.command.UpdateUser;
import com.fpmislata.MeLoPido.domain.usecase.user.query.FindAllUserByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.user.query.FindUserByCriterial;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

public class UserQueryService implements FindAllUserByCriterial, FindUserByCriterial {
    private final UserRepository userRepository;
    public UserQueryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ListWithCount<UserBasicQuery> findAll(int page, int pageSize) {
        return null;
    }

    @Override
    public ListWithCount<UserBasicQuery> findAllByGroup(int page, int pageSize, String idGroup) {
        return null;
    }

    @Override
    public UserBasicQuery findById(String idUser) {
        return null;
    }

    @Override
    public UserBasicQuery findByProductId(String idProduct) {
        return null;
    }
}
