package com.fpmislata.MeLoPido.domain.service.letter;

import com.fpmislata.MeLoPido.domain.model.Letter;
import com.fpmislata.MeLoPido.util.exception.PagedCollectionException;
import com.fpmislata.MeLoPido.util.exception.RessourceNotFoundException;
import com.fpmislata.MeLoPido.util.exception.UnauthorizedAccessException;
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
    private final String currentUser = "Ana Ortiz Gomez";
    private final List<String> currentGroup = List.of("Reyes Familia Ortiz");

    public LetterQueryService(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    @Override
    public ListWithCount<LetterBasicQuery> findAll(int page, int pageSize) {
        verifyPageAndSize(page, pageSize);

        ListWithCount<Letter> letterList = letterRepository.findAll(page, pageSize);
        return new ListWithCount<>(letterList.getList().stream().map(LetterQueryMapper::toLetterBasicQuery).toList(), letterList.getCount());
    }

    @Override
    public ListWithCount<LetterBasicQuery> findAllByUser(int page, int pageSize, String idUser) {
        verifyPageAndSize(page, pageSize);
        //verifyCurrentUser(idUser);

        ListWithCount<Letter> letterList = letterRepository.findAllByUser(page, pageSize, idUser);
        verifyCurrentUser(letterList.getList().get(0).getUser().getNameComplete());
        return new ListWithCount<>(letterList.getList().stream().map(LetterQueryMapper::toLetterBasicQuery).toList(), letterList.getCount());
    }

    @Override
    public ListWithCount<LetterBasicQuery> findAllByGroup(int page, int pageSize, String idGroup) {
        verifyPageAndSize(page, pageSize);

        ListWithCount<Letter> letterList = letterRepository.findAllByGroup(page, pageSize, idGroup);
        verifyAvailableGroup(letterList.getList().get(0).getGroup().getName());
        return new ListWithCount<>(letterList.getList().stream().map(LetterQueryMapper::toLetterBasicQuery).toList(), letterList.getCount());
    }

    @Override
    public LetterQuery findById(String idLetter) {
        LetterQuery letterQuery = LetterQueryMapper.toLetterQuery(letterRepository.findById(idLetter).orElseThrow(() -> new RessourceNotFoundException("Letter not found")));

        verifyCurrentUserOrGroup(letterQuery.user(),letterQuery.group());
        return letterQuery;

    }

    private void verifyCurrentUser(String idUser) {
        System.out.println("user:"+idUser);
        if (!idUser.equals(currentUser)) {
            throw new UnauthorizedAccessException("User does not have the necessary permissions");
        }
    }

    private void verifyAvailableGroup(String idGroup) {
        System.out.println("group:"+idGroup);
        if (!currentGroup.contains(idGroup)) {
            throw new UnauthorizedAccessException("User does not have the necessary permissions");
        }
    }

    private void verifyCurrentUserOrGroup(String idUser, String idGroup) {
        System.out.println("user:"+idUser+"group:"+idGroup);
        if (!idUser.equals(currentUser) && !currentGroup.contains(idGroup)) {
            throw new UnauthorizedAccessException("User does not have the necessary permissions");
        }
    }

    private void verifyPageAndSize(int page, int pageSize) {
        if (page < 0 || pageSize <= 0) {
            throw new PagedCollectionException("Page number and size must be greater than 0");
        }
    }
}
