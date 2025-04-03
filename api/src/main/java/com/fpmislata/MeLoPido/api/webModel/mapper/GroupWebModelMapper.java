package com.fpmislata.MeLoPido.api.webModel.mapper;

import com.fpmislata.MeLoPido.api.webModel.command.GroupRequest;
import com.fpmislata.MeLoPido.api.webModel.query.GroupBasicResponse;
import com.fpmislata.MeLoPido.api.webModel.query.GroupDetailResponse;
import com.fpmislata.MeLoPido.domain.usecase.model.command.GroupCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupQuery;

import java.util.List;

public class GroupWebModelMapper {

    public static GroupDetailResponse toGroupDetailResponse(GroupQuery groupQuery) {
        if (groupQuery == null) {
            return null;
        }
        return new GroupDetailResponse(
                groupQuery.getIdGroup(),
                groupQuery.getName(),
                groupQuery.getIcon(),
                groupQuery.getTheme(),
                groupQuery.getDescription(),
                groupQuery.getUsers(),
                LetterWebModelMapper.toLetterBasicResponseList(groupQuery.getLetters())
        );
    }

    public static List<GroupDetailResponse> toGroupDetailResponseList(List<GroupQuery> groupQueryList) {
        if (groupQueryList == null) {
            return null;
        }
        return groupQueryList.stream().map(GroupWebModelMapper::toGroupDetailResponse).toList();
    }

    public static GroupBasicResponse toGroupBasicResponse(GroupBasicQuery groupBasicQuery) {
        if (groupBasicQuery == null) {
            return null;
        }
        return new GroupBasicResponse(
                groupBasicQuery.getIdGroup(),
                groupBasicQuery.getName(),
                groupBasicQuery.getIcon(),
                groupBasicQuery.getUsers(),
                generateLink(groupBasicQuery.getIdGroup())
        );
    }

    public static List<GroupBasicResponse> toGroupBasicResponseList(List<GroupBasicQuery> groupBasicQueryList) {
        if (groupBasicQueryList == null) {
            return null;
        }
        return groupBasicQueryList.stream().map(GroupWebModelMapper::toGroupBasicResponse).toList();
    }

    public static GroupCommand toGroupCommand(GroupRequest groupRequest) {
        if (groupRequest == null) {
            return null;
        }
        return new GroupCommand(
                groupRequest.idGroup(),
                groupRequest.name(),
                groupRequest.icon(),
                groupRequest.theme(),
                groupRequest.description()
        );
    }

    private static String generateLink(String idGroup) {
        return "http://localhost:8080/api/groups/" + idGroup;
    }
}
