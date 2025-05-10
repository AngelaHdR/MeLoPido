package com.fpmislata.MeLoPido.persistence.dao.jpa.repository;

import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.ChatEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.LetterEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity,String> {
    @Query(value = """
            SELECT u.*
            FROM users u
            INNER JOIN user_group ug ON u.id_user = ug.id_user
            WHERE ug.id_group = :idGroup
            """,
            countQuery = """
            SELECT COUNT(u.*)
            FROM users u
            INNER JOIN user_group ug ON u.id_user = ug.id_user
            WHERE ug.id_group = :idGroup
            """,
            nativeQuery = true)
    Page<UserEntity> findAllByGroup(Pageable pageable, @Param("idGroup") String idGroup);

    @Query(value = """
            SELECT u.*
            FROM users u
            INNER JOIN letters l ON u.id_user = l.id_user
            INNER JOIN products p ON l.id_product = p.id_product
            WHERE p.id_product = :idProduct
            """,
            countQuery = "SELECT COUNT(*) FROM letters WHERE id_product= :idProduct",
            nativeQuery = true)
    Optional<UserEntity> findByProductId(@Param("idProduct") String idProduct);
}
