package com.fpmislata.MeLoPido.api.webModel.mapper;

import com.fpmislata.MeLoPido.api.webModel.command.UserRequest;
import com.fpmislata.MeLoPido.api.webModel.query.UserBasicResponse;
import com.fpmislata.MeLoPido.api.webModel.query.UserDetailResponse;
import com.fpmislata.MeLoPido.domain.usecase.model.command.UserCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.UserBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.UserQuery;

import java.util.List;

public class UserWebModelMapper {

    public static UserBasicResponse toUserBasicResponse(UserBasicQuery userBasicQuery) {
        return new UserBasicResponse(
                userBasicQuery.idUser(),
                userBasicQuery.nameComplete(),
                generateLink(userBasicQuery.idUser())
        );
    }

    public static List<UserBasicResponse> toUserBasicResponseList(List<UserBasicQuery> userBasicQueryList) {
        return userBasicQueryList.stream().map(UserWebModelMapper::toUserBasicResponse).toList();
    }

    public static UserDetailResponse toUserDetailQuery(UserQuery userQuery) {
        return new UserDetailResponse(
                userQuery.idUser(),
                userQuery.nameComplete(),
                userQuery.email(),
                userQuery.birthDate(),
                LetterWebModelMapper.toLetterBasicResponseList(userQuery.letters()),
                ProductWebModelMapper.toProductBasicResponseList(userQuery.products())
        );
    }

    public static UserCommand toUserCommand(UserRequest userRequest) {
        return new UserCommand(
                userRequest.idUser(),
                userRequest.name(),
                userRequest.surname1(),
                userRequest.surname2(),
                userRequest.email(),
                userRequest.birthDate(),
                userRequest.username(),
                userRequest.password()
        );
    }

    private static String generateLink(Integer idUser){
        return "http://localhost:8080/api/users/" + idUser;
    }
}
