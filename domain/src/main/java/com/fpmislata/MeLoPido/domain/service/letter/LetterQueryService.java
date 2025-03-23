package com.fpmislata.MeLoPido.domain.service.letter;

import com.fpmislata.MeLoPido.domain.usecase.letter.query.FindAllLetterByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.letter.query.FindLetterByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.LetterQueryMapper;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterQuery;
import com.fpmislata.MeLoPido.util.pagination.Page;

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
        return letterRepository.findAll(page, pageSize).map(LetterQueryMapper::toLetterBasicQuery);
    }

    @Override
    public Page<LetterBasicQuery> findAllByUser(int page, int pageSize, Integer idUser) {
        if(page<=0 || pageSize<=0){
            throw new RuntimeException("Page number and size must be greater than 0");
        }
        return letterRepository.findAllByUser(page, pageSize, idUser).map(LetterQueryMapper::toLetterBasicQuery);
    }

    @Override
    public Page<LetterBasicQuery> findAllByGroup(int page, int pageSize, Integer idGroup) {
        if(page<=0 || pageSize<=0){
            throw new RuntimeException("Page number and size must be greater than 0");
        }
        return letterRepository.findAllByGroup(page, pageSize, idGroup).map(LetterQueryMapper::toLetterBasicQuery);
    }

    @Override
    public LetterQuery findById(Integer idLetter) {
        return LetterQueryMapper.toLetterQuery(letterRepository.findById(idLetter));
    }
}
