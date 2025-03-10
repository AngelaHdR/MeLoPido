package com.fpmislata.MeLoPido.api.webModel.mapper;

import com.fpmislata.MeLoPido.api.webModel.command.LetterRequest;
import com.fpmislata.MeLoPido.api.webModel.query.LetterBasicResponse;
import com.fpmislata.MeLoPido.api.webModel.query.LetterDetailResponse;
import com.fpmislata.MeLoPido.domain.usecase.model.command.LetterCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterQuery;

import java.util.List;

public class LetterWebModelMapper {
    public static LetterDetailResponse toLetterDetailResponse(LetterQuery letterQuery){
        return new LetterDetailResponse(
                letterQuery.idLetter(),
                letterQuery.description(),
                letterQuery.user(),
                letterQuery.group(),
                ProductWebModelMapper.toProductCollectionResponseList(letterQuery.products())
        );
    }

    public static List<LetterDetailResponse> toLetterDetailResponseList(List<LetterQuery> letterQueryList){
        return letterQueryList.stream().map(LetterWebModelMapper::toLetterDetailResponse).toList();
    }

    public static LetterBasicResponse toLetterBasicResponse(LetterBasicQuery letterBasicQuery){
        return new LetterBasicResponse(
                letterBasicQuery.idLetter(),
                letterBasicQuery.description(),
                letterBasicQuery.user(),
                letterBasicQuery.group(),
                generateLink(letterBasicQuery.idLetter())
        );
    }

    public static List<LetterBasicResponse> toLetterBasicResponseList(List<LetterBasicQuery> letterBasicQueryList){
        return letterBasicQueryList.stream().map(LetterWebModelMapper::toLetterBasicResponse).toList();
    }


    public static LetterCommand toLetterCommand(LetterRequest letterRequest){
        return new LetterCommand(
                letterRequest.idLetter(),
                letterRequest.description(),
                letterRequest.idUser(),
                letterRequest.creationDate(),
                letterRequest.idGroup(),
                letterRequest.sendDate(),
                ProductWebModelMapper.toProductCommandList(letterRequest.products())
        );
    }

    private static String generateLink(Integer idLetter){
        return "http://localhost:8080/api/letters/" + idLetter;
    }
}
