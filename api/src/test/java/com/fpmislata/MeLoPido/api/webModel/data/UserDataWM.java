package com.fpmislata.MeLoPido.api.webModel.data;

import com.fpmislata.MeLoPido.api.webModel.command.UserRequest;
import com.fpmislata.MeLoPido.api.webModel.query.UserBasicResponse;
import com.fpmislata.MeLoPido.api.webModel.query.UserDetailResponse;
import com.fpmislata.MeLoPido.domain.usecase.model.command.UserCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.UserBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.UserQuery;

import java.util.List;

public class UserDataWM {
    private static final List<UserDetailResponse> usersDetailResponse = List.of(
            new UserDetailResponse("1","User 1 Surname1 1 Surname2 1", "email 1", "2000-04-21", "username 1", "password 1", LetterDataWM.getLettersBasicResponse(), ProductDataWM.getProductsBasicResponse(),GroupDataWM.getGroupsBasicResponse()),
            new UserDetailResponse("2","User 2 Surname1 2 Surname2 2", "email 2", "2000-04-22", "username 2", "password 2",LetterDataWM.getLettersBasicResponse(), ProductDataWM.getProductsBasicResponse(),GroupDataWM.getGroupsBasicResponse()),
            new UserDetailResponse("3","User 3 Surname1 3 Surname2 3", "email 3", "2000-04-23", "username 3", "password 3",LetterDataWM.getLettersBasicResponse(), ProductDataWM.getProductsBasicResponse(),GroupDataWM.getGroupsBasicResponse())
    );

    private static final List<UserBasicResponse> usersBasic = List.of(
            new UserBasicResponse("1", "User 1 Surname1 1 Surname2 1", "Link 1"),
            new UserBasicResponse("2", "User 2 Surname1 2 Surname2 2", "Link 2"),
            new UserBasicResponse("3", "User 3 Surname1 3 Surname2 3", "Link 3")
    );

    private static final List<UserRequest> usersRequest = List.of(
            new UserRequest("1", "User 1", "Surname1 1", "Surname2 1", "email 1", "2000-04-21", "username 1", "password 1"),
            new UserRequest("2", "User 2", "Surname1 2", "Surname2 2", "email 2", "2000-04-22", "username 2", "password 2"),
            new UserRequest("3", "User 3", "Surname1 3", "Surname2 3", "email 3", "2000-04-23", "username 3", "password 3")
    );

    public static List<UserDetailResponse> getUsersDetailResponse(){
        return usersDetailResponse;
    }

    public static List<UserBasicResponse> getUsersBasicResponse(){
        return usersBasic;
    }

    public static List<UserRequest> getUsersRequest(){
        return usersRequest;
    }
}
