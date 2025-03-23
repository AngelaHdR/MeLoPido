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
        if (userQuery == null) {
            return null;
        }
        return new UserDetailResponse(
                userQuery.getIdUser(),
                userQuery.getNameComplete(),
                userQuery.getEmail(),
                userQuery.getBirthDate(),
                userQuery.getUsername(),
                userQuery.getPassword(),
                LetterWebModelMapper.toLetterBasicResponseList(userQuery.getLetters()),
                ProductWebModelMapper.toProductBasicResponseList(userQuery.getProducts())
        );
    }

    public static UserCommand toUserCommand(UserRequest userRequest) {
        if (userRequest == null) {
            return null;
        }
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

    private static String generateLink(String idUser) {
        return "http://localhost:8080/api/users/" + idUser;
    }
}
