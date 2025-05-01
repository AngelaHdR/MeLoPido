package com.fpmislata.MeLoPido.persistence.dao.jpa.repository;

import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.LetterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LetterJpaRepository extends JpaRepository<LetterEntity, String> {
    @Query(value = "SELECT * FROM letters WHERE id_user = :idUser",
            countQuery = "SELECT COUNT(*) FROM letters WHERE id_user = :idUser",
            nativeQuery = true)
    Page<LetterEntity> findAllByUser(Pageable pageable, String idUser);

    @Query(value = "SELECT * FROM letters WHERE id_group = :idGroup",
            countQuery = "SELECT COUNT(*) FROM letters WHERE id_group = :idGroup",
            nativeQuery = true)
    Page<LetterEntity> findAllByGroup(Pageable pageable, String idGroup);
}
