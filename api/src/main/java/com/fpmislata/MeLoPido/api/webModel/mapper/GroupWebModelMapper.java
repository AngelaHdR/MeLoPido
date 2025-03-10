package com.fpmislata.MeLoPido.api.webModel.mapper;

import com.fpmislata.MeLoPido.api.webModel.command.GroupRequest;
import com.fpmislata.MeLoPido.api.webModel.query.GroupBasicResponse;
import com.fpmislata.MeLoPido.api.webModel.query.GroupDetailResponse;
import com.fpmislata.MeLoPido.domain.usecase.model.command.GroupCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupQuery;

import java.util.List;

public class GroupWebModelMapper {

    public static GroupDetailResponse toGroupDetailResponse(GroupQuery groupQuery){
        return new GroupDetailResponse(
                groupQuery.idGroup(),
                groupQuery.name(),
                groupQuery.icon(),
                UserWebModelMapper.toUserBasicResponseList(groupQuery.users()),
                LetterWebModelMapper.toLetterBasicResponseList(groupQuery.letters())
        );
    }

    public static List<GroupDetailResponse> toGroupDetailResponseList(List<GroupQuery> groupQueryList){
        return groupQueryList.stream().map(GroupWebModelMapper::toGroupDetailResponse).toList();
    }

    public static GroupBasicResponse toGroupBasicResponse(GroupBasicQuery groupBasicQuery){
        return new GroupBasicResponse(
                groupBasicQuery.idGroup(),
                groupBasicQuery.name(),
                groupBasicQuery.icon(),
                groupBasicQuery.users(),
                generateLink(groupBasicQuery.idGroup())
        );
    }

    public static List<GroupBasicResponse> toGroupBasicResponseList(List<GroupBasicQuery> groupBasicQueryList){
        return groupBasicQueryList.stream().map(GroupWebModelMapper::toGroupBasicResponse).toList();
    }

    public static GroupCommand toGroupCommand(GroupRequest groupRequest) {
        return new GroupCommand(
                groupRequest.idGroup(),
                groupRequest.name(),
                groupRequest.icon(),
                groupRequest.theme(),
                groupRequest.description()
        );
    }

    private static String generateLink(Integer idGroup){
        return "http://localhost:8080/api/groups/" + idGroup;
    }
}
