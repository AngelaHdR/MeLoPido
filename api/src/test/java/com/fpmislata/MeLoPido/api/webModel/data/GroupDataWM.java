package com.fpmislata.MeLoPido.api.webModel.data;

import com.fpmislata.MeLoPido.api.data.UserData;
import com.fpmislata.MeLoPido.api.webModel.command.GroupRequest;
import com.fpmislata.MeLoPido.api.webModel.query.GroupBasicResponse;
import com.fpmislata.MeLoPido.api.webModel.query.GroupDetailResponse;

import java.util.List;

public class GroupDataWM {
    private static final List<GroupDetailResponse> groupsDetailResponse = List.of(
            new GroupDetailResponse("1", "Group 1", "Icon 1", "Theme 1", "Description 1", UserData.getUsersName(), LetterDataWM.getLettersBasicResponse()),
            new GroupDetailResponse("2", "Group 2", "Icon 2", "Theme 2", "Description 2", UserData.getUsersName(), LetterDataWM.getLettersBasicResponse()),
            new GroupDetailResponse("3", "Group 3", "Icon 3", "Theme 3", "Description 3", UserData.getUsersName(), LetterDataWM.getLettersBasicResponse())
    );

    private static final List<GroupBasicResponse> groupsBasicResponse = List.of(
            new GroupBasicResponse("1", "Group 1", "Icon 1", UserData.getUsersName(), "Link 1"),
            new GroupBasicResponse("2", "Group 2", "Icon 2", UserData.getUsersName(), "Link 2"),
            new GroupBasicResponse("3", "Group 3", "Icon 3", UserData.getUsersName(), "Link 3")
    );

    private static final List<GroupRequest> groupsRequest = List.of(
            new GroupRequest("1", "Group 1", "Icon 1", "Theme 1", "Description 1"),
            new GroupRequest("2", "Group 2", "Icon 2", "Theme 2", "Description 2"),
            new GroupRequest("3", "Group 3", "Icon 3", "Theme 3", "Description 3")
    );

    public static List<GroupDetailResponse> getGroupsDetailResponse(){
        return groupsDetailResponse;
    }

    public static List<GroupBasicResponse> getGroupsBasicResponse(){
        return groupsBasicResponse;
    }

    public static List<GroupRequest> getGroupsRequest(){
        return groupsRequest;
    }
}
