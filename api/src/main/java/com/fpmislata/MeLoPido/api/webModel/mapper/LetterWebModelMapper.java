package com.fpmislata.MeLoPido.api.webModel.mapper;

import com.fpmislata.MeLoPido.api.webModel.command.LetterRequest;
import com.fpmislata.MeLoPido.api.webModel.query.LetterBasicResponse;
import com.fpmislata.MeLoPido.api.webModel.query.LetterDetailResponse;
import com.fpmislata.MeLoPido.domain.usecase.model.command.LetterCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterQuery;

import java.util.List;

public class LetterWebModelMapper {
    public static LetterDetailResponse toLetterDetailResponse(LetterQuery letterQuery) {
        if (letterQuery == null) {
            return null;
        }
        return new LetterDetailResponse(
                letterQuery.idLetter(),
                letterQuery.description(),
                letterQuery.creationDate(),
                letterQuery.sendDate(),
                letterQuery.expirationDate(),
                UserWebModelMapper.toUserBasicResponse(letterQuery.user()),
                GroupWebModelMapper.toGroupBasicResponse(letterQuery.group()),
                ProductWebModelMapper.toProductBasicResponseList(letterQuery.products())
        );
    }

    public static List<LetterDetailResponse> toLetterDetailResponseList(List<LetterQuery> letterQueryList) {
        if (letterQueryList == null) {
            return null;
        }
        return letterQueryList.stream().map(LetterWebModelMapper::toLetterDetailResponse).toList();
    }

    public static LetterBasicResponse toLetterBasicResponse(LetterBasicQuery letterBasicQuery) {
        if (letterBasicQuery == null) {
            return null;
        }
        return new LetterBasicResponse(
                letterBasicQuery.idLetter(),
                letterBasicQuery.description(),
                generateLink(letterBasicQuery.idLetter())
        );
    }

    public static List<LetterBasicResponse> toLetterBasicResponseList(List<LetterBasicQuery> letterBasicQueryList) {
        if (letterBasicQueryList == null) {
            return null;
        }
        return letterBasicQueryList.stream().map(LetterWebModelMapper::toLetterBasicResponse).toList();
    }


    public static LetterCommand toLetterCommand(LetterRequest letterRequest) {
        if (letterRequest == null) {
            return null;
        }
        return new LetterCommand(
                letterRequest.idLetter(),
                letterRequest.description(),
                letterRequest.idUser(),
                letterRequest.creationDate(),
                ProductWebModelMapper.toProductCommandList(letterRequest.products())
        );
    }

    private static String generateLink(String idLetter) {
        return "http://localhost:8080/api/letters/" + idLetter;
    }
}
