package com.fpmislata.MeLoPido.persistence.dao.jpa.repository;

import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.GroupEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.LetterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupJpaRepository extends JpaRepository<GroupEntity, String> {
    @Query(value = """
            SELECT g.*
            FROM groups_detail g
            INNER JOIN letters l ON g.id_group = l.id_group
            WHERE l.id_user = :idUser
            """,
            countQuery = """
            SELECT COUNT(g.*)
            FROM groups_detail g
            INNER JOIN letters l ON g.id_group = l.id_group
            WHERE l.id_user = :idUser
            """,
            nativeQuery = true)
    Page<GroupEntity> findAllByUser(Pageable pageable, String idUser);
}
