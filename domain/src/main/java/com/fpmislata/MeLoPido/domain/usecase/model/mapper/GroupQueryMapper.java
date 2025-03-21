package com.fpmislata.MeLoPido.domain.usecase.model.mapper;

import com.fpmislata.MeLoPido.domain.model.Group;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupQuery;

public class GroupQueryMapper {
    public static GroupQuery toGroupQuery(Group group){
        return new GroupQuery(
                group.getIdGroup(),
                group.getName(),
                group.getIcon(),
                //UserQueryMapper.toUserCollectionQueryList(group.getUsers()),
                //LetterQueryMapper.toLetterCollectionQueryList(group.getLetters())
        );
    }
}
