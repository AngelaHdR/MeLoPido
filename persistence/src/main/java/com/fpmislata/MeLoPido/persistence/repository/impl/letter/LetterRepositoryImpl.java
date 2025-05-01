package com.fpmislata.MeLoPido.persistence.repository.impl.letter;

import com.fpmislata.MeLoPido.domain.model.Letter;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.LetterEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.mapper.LetterEntityMapper;
import com.fpmislata.MeLoPido.persistence.dao.jpa.repository.LetterJpaRepository;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import com.fpmislata.MeLoPido.domain.repository.LetterRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class LetterRepositoryImpl implements LetterRepository {
    private LetterJpaRepository letterJpaRepository;

    //TODO: como se haria el UUID
    @Override
    public ListWithCount<Letter> findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<LetterEntity> pages = letterJpaRepository.findAll(pageable);
        return new ListWithCount<>(pages.stream().map(LetterEntityMapper::toLetter).toList(), pages.getTotalElements());
    }

    @Override
    public Optional<Letter> findById(String id) {
        return letterJpaRepository.findById(id).map(LetterEntityMapper::toLetter);
    }

    @Override
    public void delete(String id) {
        letterJpaRepository.deleteById(id);
    }

    public int count() {
        return (int) letterJpaRepository.count();
    }

    @Override
    public void save(Letter letter) {
        letterJpaRepository.save(LetterEntityMapper.toLetterEntity(letter));
    }

    @Override
    public ListWithCount<Letter> findAllByUser(int page, int pageSize, String idUser) {
        Pageable pageable = PageRequest.of(page,pageSize);
        Page<LetterEntity> pages = letterJpaRepository.findAllByUser(pageable, idUser);
        return new ListWithCount<>(pages.stream().map(LetterEntityMapper::toLetter).toList(), pages.getTotalElements());
    }

    @Override
    public ListWithCount<Letter> findAllByGroup(int page, int pageSize, String idGroup) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<LetterEntity> pages = letterJpaRepository.findAllByGroup(pageable, idGroup);
        return new ListWithCount<>(pages.stream().map(LetterEntityMapper::toLetter).toList(), pages.getTotalElements());
    }
}
