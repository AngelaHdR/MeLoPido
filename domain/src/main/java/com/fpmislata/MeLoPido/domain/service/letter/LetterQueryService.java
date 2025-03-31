package com.fpmislata.MeLoPido.domain.service.letter;

import com.fpmislata.MeLoPido.domain.model.Letter;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import com.fpmislata.MeLoPido.domain.repository.LetterRepository;
import com.fpmislata.MeLoPido.domain.usecase.letter.query.FindAllLetterByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.letter.query.FindLetterByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.LetterQueryMapper;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterQuery;

public class LetterQueryService implements FindAllLetterByCriterial, FindLetterByCriterial {
    private final LetterRepository letterRepository;

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
        ListWithCount<Letter> letterList = letterRepository.findAllByUser(page, pageSize, idUser);
        return new ListWithCount<>(letterList.getList().stream().map(LetterQueryMapper::toLetterBasicQuery).toList(), letterList.getCount());
    }

    @Override
    public ListWithCount<LetterBasicQuery> findAllByGroup(int page, int pageSize, String idGroup) {
        if (page <= 0 || pageSize <= 0) {
            throw new RuntimeException("Page number and size must be greater than 0");
        }
        ListWithCount<Letter> letterList = letterRepository.findAllByGroup(page, pageSize, idGroup);
        return new ListWithCount<>(letterList.getList().stream().map(LetterQueryMapper::toLetterBasicQuery).toList(), letterList.getCount());
    }

    @Override
    public LetterQuery findById(String idLetter) {
        return LetterQueryMapper.toLetterQuery(letterRepository.findById(idLetter));
    }
}
