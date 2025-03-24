package com.fpmislata.MeLoPido.domain.service.letter;

import com.fpmislata.MeLoPido.domain.repository.LetterRepository;
import com.fpmislata.MeLoPido.domain.usecase.letter.query.FindAllLetterByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.letter.query.FindLetterByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.LetterQueryMapper;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterQuery;
import com.fpmislata.MeLoPido.util.pagination.Page;

import java.util.List;

public class LetterQueryService implements FindAllLetterByCriterial, FindLetterByCriterial {
    private final LetterRepository letterRepository;

    public LetterQueryService(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    @Override
    public Page<LetterBasicQuery> findAll(int page, int pageSize) {
        if(page<=0 || pageSize<=0){
            throw new RuntimeException("Page number and size must be greater than 0");
        }
        List<LetterBasicQuery> letterBasicQueryPage = letterRepository.findAll(page, pageSize).data().stream().map(LetterQueryMapper::toLetterBasicQuery).toList();
        return new Page<LetterBasicQuery>(letterBasicQueryPage, page, pageSize, letterBasicQueryPage.size());
    }

    @Override
    public Page<LetterBasicQuery> findAllByUser(int page, int pageSize, String idUser) {
        if(page<=0 || pageSize<=0){
            throw new RuntimeException("Page number and size must be greater than 0");
        }
        List<LetterBasicQuery> letterBasicQueryPage = letterRepository.findAll(page, pageSize).data().stream().map(LetterQueryMapper::toLetterBasicQuery).toList();
        return new Page<LetterBasicQuery>(letterBasicQueryPage, page, pageSize, letterBasicQueryPage.size());
    }

    @Override
    public Page<LetterBasicQuery> findAllByGroup(int page, int pageSize, String idGroup) {
        if(page<=0 || pageSize<=0){
            throw new RuntimeException("Page number and size must be greater than 0");
        }
        List<LetterBasicQuery> letterBasicQueryPage = letterRepository.findAll(page, pageSize).data().stream().map(LetterQueryMapper::toLetterBasicQuery).toList();
        return new Page<LetterBasicQuery>(letterBasicQueryPage, page, pageSize, letterBasicQueryPage.size());
    }

    @Override
    public LetterQuery findById(String idLetter) {
        return LetterQueryMapper.toLetterQuery(letterRepository.findById(idLetter));
    }
}
