package com.fpmislata.MeLoPido.persistence.repository.impl.letter;

import com.fpmislata.MeLoPido.domain.model.Letter;
import com.fpmislata.MeLoPido.persistence.dao.LetterDaoDb;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import com.fpmislata.MeLoPido.domain.repository.LetterRepository;

import java.util.Optional;

public class LetterRepositoryImpl implements LetterRepository {
    private final LetterDaoDb letterDaoDb;

    public LetterRepositoryImpl(LetterDaoDb letterDaoDb) {
        this.letterDaoDb = letterDaoDb;
    }

    @Override
    public ListWithCount<Letter> findAll(int page, int pageSize) {
        return letterDaoDb.findAll(page, pageSize);
    }

    @Override
    public ListWithCount<Letter> findAllByUser(int page, int pageSize, String idUser) {
        return letterDaoDb.findAllByUser(page, pageSize, idUser);
    }

    @Override
    public ListWithCount<Letter> findAllByGroup(int page, int pageSize, String idGroup) {
        return letterDaoDb.findAllByGroup(page, pageSize, idGroup);
    }

    @Override
    public Optional<Letter> findById(String idLetter) {
        return letterDaoDb.findById(idLetter);
    }

    @Override
    public void save(Letter letter) {
        letterDaoDb.save(letter);
    }

    @Override
    public void delete(String idLetter) {
        letterDaoDb.delete(idLetter);
    }
}
