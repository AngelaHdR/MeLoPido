package com.fpmislata.MeLoPido.persistence.repository.impl.letter;

import com.fpmislata.MeLoPido.domain.model.Letter;
import com.fpmislata.MeLoPido.persistence.dao.LetterDao;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.LetterEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.mapper.LetterEntityMapper;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import com.fpmislata.MeLoPido.domain.repository.LetterRepository;

import java.util.Optional;

public class LetterRepositoryImpl implements LetterRepository {
    private LetterDao letterDao;

    public LetterRepositoryImpl(LetterDao letterDao) {
        this.letterDao = letterDao;
    }

    @Override
    public ListWithCount<Letter> findAll(int page, int pageSize) {
        ListWithCount<LetterEntity> list = letterDao.findAll(page, pageSize);
        return new ListWithCount<>(list.getList().stream().map(LetterEntityMapper::toLetter).toList(), list.getCount());
    }

    @Override
    public Optional<Letter> findById(String id) {
        return letterDao.findById(id).map(LetterEntityMapper::toLetter);
    }

    @Override
    public void delete(String id) {
        letterDao.delete(id);
    }

    @Override
    public void save(Letter letter) {
        letterDao.save(LetterEntityMapper.toLetterEntity(letter));
    }

    @Override
    public ListWithCount<Letter> findAllByUser(int page, int pageSize, String idUser) {
        ListWithCount<LetterEntity> list = letterDao.findAllByUser(page,pageSize, idUser);
        return new ListWithCount<>(list.getList().stream().map(LetterEntityMapper::toLetter).toList(), list.getCount());
    }

    @Override
    public ListWithCount<Letter> findAllByGroup(int page, int pageSize, String idGroup) {
        ListWithCount<LetterEntity> list = letterDao.findAllByGroup(page, pageSize, idGroup);
        return new ListWithCount<>(list.getList().stream().map(LetterEntityMapper::toLetter).toList(), list.getCount());
    }
}
