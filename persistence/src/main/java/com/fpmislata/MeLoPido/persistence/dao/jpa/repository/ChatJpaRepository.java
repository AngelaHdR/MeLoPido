package com.fpmislata.MeLoPido.persistence.dao.jpa.repository;

import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.ChatEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.LetterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ChatJpaRepository extends JpaRepository<ChatEntity, String> {
    @Query(value = """
            SELECT c.*
            FROM chats c
            INNER JOIN products p ON c.id_product = p.id_product
            INNER JOIN letters l ON p.id_letter = l.id_letter
            WHERE l.id_user = :idUser OR p.assigned_to = :idUser
            """,
            countQuery = """
                    SELECT COUNT(c.*)
                    FROM chats c
                    INNER JOIN products p ON c.id_product = p.id_product
                    INNER JOIN letters l ON p.id_letter = l.id_letter
                    WHERE l.id_user = :idUser OR p.assigned_to = :idUser
                    """,
            nativeQuery = true)
    Page<ChatEntity> findAllByUser(Pageable pageable, @Param("idUser") String idUser);

    @Query(value = "SELECT * FROM chat WHERE id_product= :idProduct",
            countQuery = "SELECT COUNT(*) FROM letters WHERE id_product= :idProduct",
            nativeQuery = true)
    Optional<ChatEntity> findByIdProduct(@Param("idProduct") String idProduct);


}
