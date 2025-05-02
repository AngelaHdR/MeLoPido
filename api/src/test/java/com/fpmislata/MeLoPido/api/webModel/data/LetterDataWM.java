package com.fpmislata.MeLoPido.api.webModel.data;

import com.fpmislata.MeLoPido.api.data.GroupData;
import com.fpmislata.MeLoPido.api.data.UserData;
import com.fpmislata.MeLoPido.api.webModel.command.LetterRequest;
import com.fpmislata.MeLoPido.api.webModel.query.LetterBasicResponse;
import com.fpmislata.MeLoPido.api.webModel.query.LetterDetailResponse;

import java.util.List;

public class LetterDataWM {

    private static final List<LetterDetailResponse> lettersDetailResponse = List.of(
            new LetterDetailResponse("1", "Letter 1","2021-01-01", "2021-02-01", "2021-03-01", UserData.getUsersName().get(0), GroupData.getGroupsName().get(0), ProductDataWM.getProductsBasicResponse()),
            new LetterDetailResponse("2", "Letter 2", "2021-02-01", "2021-03-01", "2021-04-01", UserData.getUsersName().get(1), GroupData.getGroupsName().get(1), ProductDataWM.getProductsBasicResponse()),
            new LetterDetailResponse("3", "Letter 3", "2021-03-01", "2021-04-01", "2021-05-01", UserData.getUsersName().get(2), GroupData.getGroupsName().get(2), ProductDataWM.getProductsBasicResponse())
    );

    private static final List<LetterBasicResponse> lettersBasicResponse = List.of(
            new LetterBasicResponse("1", "Letter 1", UserData.getUsersName().get(0), GroupData.getGroupsName().get(0), "Link 1"),
            new LetterBasicResponse("2", "Letter 2", UserData.getUsersName().get(1), GroupData.getGroupsName().get(1), "Link 2"),
            new LetterBasicResponse("3", "Letter 3", UserData.getUsersName().get(2), GroupData.getGroupsName().get(2), "Link 3")
    );

    private static final List<LetterRequest> lettersRequest = List.of(
            new LetterRequest("1", "Letter 1", UserData.getUsersName().get(0), "2021-01-01", ProductDataWM.getProductsRequest()),
            new LetterRequest("2", "Letter 2", UserData.getUsersName().get(1), "2021-02-01", ProductDataWM.getProductsRequest()),
            new LetterRequest("3", "Letter 3", UserData.getUsersName().get(2), "2021-03-01", ProductDataWM.getProductsRequest())
    );

    public static List<LetterDetailResponse> getLettersDetailResponse() {
        return lettersDetailResponse;
    }

    public static List<LetterBasicResponse> getLettersBasicResponse() {
        return lettersBasicResponse;
    }

    public static List<LetterRequest> getLettersRequest() {
        return lettersRequest;
    }
}
