package com.fpmislata.MeLoPido.persistence.dao.jpa;

import com.fpmislata.MeLoPido.persistence.dao.ChatDao;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.ChatEntity;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ChatDaoJpa implements ChatDao {
    private final EntityManager entityManager;

    public ChatDaoJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ListWithCount<ChatEntity> findAllByUser(int page, int pageSize, String idUser) {
        String queryStr = """
                    SELECT c FROM ChatEntity c
                    JOIN c.product p
                    JOIN p.letter l
                    WHERE l.user.id = :idUser
                """;
        String countStr = """
                    SELECT COUNT(c) FROM ChatEntity c
                    JOIN c.product p
                    JOIN p.letter l
                    WHERE l.user.id = :idUser
                """;

        List<ChatEntity> result = entityManager.createQuery(queryStr, ChatEntity.class)
                .setParameter("idUser", idUser)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .getResultList();

        Long total = entityManager.createQuery(countStr, Long.class)
                .setParameter("idUser", idUser)
                .getSingleResult();

        return new ListWithCount<>(result, total);
    }

    @Override
    public Optional<ChatEntity> findByIdProduct(String idProduct) {
        String query = "SELECT c FROM ChatEntity l " + "WHERE c.product.id = :idProduct";
        try {
            return Optional.of(entityManager.createQuery(query, ChatEntity.class)
                    .setParameter("idProduct", idProduct)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public ListWithCount<ChatEntity> findAll(int page, int pageSize) {
        String queryStr = "SELECT c FROM ChatEntity c";
        String countStr = "SELECT COUNT(c) FROM ChatEntity c";

        List<ChatEntity> result = entityManager.createQuery(queryStr, ChatEntity.class)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .getResultList();

        Long total = entityManager.createQuery(countStr, Long.class)
                .getSingleResult();

        return new ListWithCount<>(result, total);
    }

    @Override
    public Optional<ChatEntity> findById(String id) {
        String query = "SELECT c FROM ChatEntity l " + "WHERE c.id = :idChat";
        try {
            return Optional.of(entityManager.createQuery(query, ChatEntity.class)
                    .setParameter("idChat", id)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public String save(ChatEntity chat) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            if (chat.getIdChat() == null || chat.getIdChat().isEmpty()) {
                chat.setIdChat(UUID.randomUUID().toString());
            }
            ChatEntity managedChat = entityManager.merge(chat);


            transaction.commit();
            return managedChat.getIdChat();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void delete(String id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            ChatEntity chat = entityManager.find(ChatEntity.class, id);
            if (chat != null) {
                entityManager.remove(chat);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
