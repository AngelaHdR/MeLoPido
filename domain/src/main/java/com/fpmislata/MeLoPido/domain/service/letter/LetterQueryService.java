package com.fpmislata.MeLoPido.domain.service.letter;

import com.fpmislata.MeLoPido.domain.model.Letter;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import com.fpmislata.MeLoPido.domain.repository.LetterRepository;
import com.fpmislata.MeLoPido.domain.usecase.letter.query.FindAllLetterByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.letter.query.FindLetterByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.LetterQueryMapper;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterQuery;

import java.util.List;

public class LetterQueryService implements FindAllLetterByCriterial, FindLetterByCriterial {
    private final LetterRepository letterRepository;
    private final String currentUser = "1";
    private final List<String> currentGroup = List.of("1", "2");

    public LetterQueryService(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    @Override
    public ListWithCount<LetterBasicQuery> findAll(int page, int pageSize) {
        if (page <= 0 || pageSize <= 0) {
            throw new RuntimeException("Page number and size must be greater than 0");
        }
        ListWithCount<Letter> letterList = letterRepository.findAll(page, pageSize);
        return new ListWithCount<>(letterList.getList().stream().map(LetterQueryMapper::toLetterBasicQuery).toList(), letterList.getCount());
    }

    @Override
    public ListWithCount<LetterBasicQuery> findAllByUser(int page, int pageSize, String idUser) {
        if (page <= 0 || pageSize <= 0) {
            throw new RuntimeException("Page number and size must be greater than 0");
        }
        if(!isFromCurrentUser(idUser)){
            throw new RuntimeException("The user hasn't the right permits");
        }
        ListWithCount<Letter> letterList = letterRepository.findAllByUser(page, pageSize, idUser);
        return new ListWithCount<>(letterList.getList().stream().map(LetterQueryMapper::toLetterBasicQuery).toList(), letterList.getCount());
    }

    @Override
    public ListWithCount<LetterBasicQuery> findAllByGroup(int page, int pageSize, String idGroup) {
        if (page <= 0 || pageSize <= 0) {
            throw new RuntimeException("Page number and size must be greater than 0"); //TODO: create a custom exception for pagination errors
        }
        if (!isFromAvailableGroup(idGroup)) {
            throw new RuntimeException("The user hasn't the right permits");
        }
        ListWithCount<Letter> letterList = letterRepository.findAllByGroup(page, pageSize, idGroup);
        return new ListWithCount<>(letterList.getList().stream().map(LetterQueryMapper::toLetterBasicQuery).toList(), letterList.getCount());
    }

    @Override
    public LetterQuery findById(String idLetter) {
        LetterQuery letterQuery = LetterQueryMapper.toLetterQuery(letterRepository.findById(idLetter));
        if (isFromCurrentUser(letterQuery.user()) || isFromAvailableGroup(letterQuery.group())) {
            return letterQuery;
        }
        throw new RuntimeException("The user hasn't the right permits"); //TODO: create a custom exception for permissions errors
    }

    private boolean isFromCurrentUser(String idUser) {
        return idUser.equals(currentUser);
    }

    private boolean isFromAvailableGroup(String idGroup) {
        for (String group : currentGroup) {
            if (group.equals(idGroup)) {
                return true;
            }
        }
        return false;
    }
}
