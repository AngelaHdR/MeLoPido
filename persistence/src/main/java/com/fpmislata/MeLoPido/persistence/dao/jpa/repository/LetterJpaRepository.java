package com.fpmislata.MeLoPido.persistence.dao.jpa.repository;

import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.LetterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LetterJpaRepository extends JpaRepository<LetterEntity, String> {
    //TODO: acabar de implementar los metodos
    Page<LetterEntity> findAllByUser(int page, int pageSize, String idUser);
    Page<LetterEntity> findAllByGroup(int page, int pageSize, String idGroup);
}
