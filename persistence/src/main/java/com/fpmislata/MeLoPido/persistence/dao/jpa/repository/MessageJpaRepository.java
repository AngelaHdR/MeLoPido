package com.fpmislata.MeLoPido.persistence.dao.jpa.repository;

import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.LetterEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.MessageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageJpaRepository extends JpaRepository<MessageEntity, String> {
    @Query(value = "SELECT * FROM messages WHERE id_chat = :idChat ORDER BY send_date ASC", nativeQuery = true)
    List<MessageEntity> findAllByChat(String idChat);
}
