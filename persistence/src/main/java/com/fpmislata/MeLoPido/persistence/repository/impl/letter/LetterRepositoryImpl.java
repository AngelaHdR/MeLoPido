package com.fpmislata.MeLoPido.persistence.repository.impl.letter;

import com.fpmislata.MeLoPido.domain.model.Letter;
import com.fpmislata.MeLoPido.persistence.dao.LetterDao;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.LetterEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.mapper.LetterEntityMapper;
import com.fpmislata.MeLoPido.persistence.dao.jpa.repository.LetterJpaRepository;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import com.fpmislata.MeLoPido.domain.repository.LetterRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class LetterRepositoryImpl implements LetterRepository {
    //private LetterJpaRepository letterJpaRepository;
    private LetterDao letterJpaRepository;

    public LetterRepositoryImpl(LetterDao letterJpaRepository) {
        this.letterJpaRepository = letterJpaRepository;
    }

    //TODO: como se haria el UUID
    @Override
    public ListWithCount<Letter> findAll(int page, int pageSize) {
        ListWithCount<LetterEntity> pages = letterJpaRepository.findAll(page, pageSize);
        return new ListWithCount<>(pages.getList().stream().map(LetterEntityMapper::toLetter).toList(), pages.getCount());
    }

    @Override
    public Optional<Letter> findById(String id) {
        return letterJpaRepository.findById(id).map(LetterEntityMapper::toLetter);
    }

    @Override
    public void delete(String id) {
        //letterJpaRepository.deleteById(id);
    }



    @Override
    public void save(Letter letter) {
        letterJpaRepository.save(LetterEntityMapper.toLetterEntity(letter));
    }

    @Override
    public ListWithCount<Letter> findAllByUser(int page, int pageSize, String idUser) {
        ListWithCount<LetterEntity> pages = letterJpaRepository.findAllByUser(page,pageSize, idUser);
        return new ListWithCount<>(pages.getList().stream().map(LetterEntityMapper::toLetter).toList(), pages.getCount());
    }

    @Override
    public ListWithCount<Letter> findAllByGroup(int page, int pageSize, String idGroup) {
        ListWithCount<LetterEntity> pages = letterJpaRepository.findAllByGroup(page, pageSize, idGroup);
        return new ListWithCount<>(pages.getList().stream().map(LetterEntityMapper::toLetter).toList(), pages.getCount());
    }
}
