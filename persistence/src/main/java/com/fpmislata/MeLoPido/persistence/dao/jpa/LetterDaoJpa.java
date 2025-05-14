package com.fpmislata.MeLoPido.persistence.dao.jpa;

import com.fpmislata.MeLoPido.persistence.dao.LetterDao;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.LetterEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.ProductEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.UserEntity;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class LetterDaoJpa implements LetterDao {
    private final EntityManager entityManager;

    public LetterDaoJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ListWithCount<LetterEntity> findAllByUser(int page, int pageSize, String idUser) {
        String queryStr = "SELECT l FROM LetterEntity l WHERE l.user.id = :idUser";
        String countStr = "SELECT COUNT(l) FROM LetterEntity l WHERE l.user.id = :idUser";

        List<LetterEntity> result = entityManager.createQuery(queryStr, LetterEntity.class)
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
    public ListWithCount<LetterEntity> findAllByGroup(int page, int pageSize, String idGroup) {
        String queryStr = "SELECT l FROM LetterEntity l WHERE l.group.id = :idGroup";
        String countStr = "SELECT COUNT(l) FROM LetterEntity l WHERE l.group.id = :idGroup";

        List<LetterEntity> result = entityManager.createQuery(queryStr, LetterEntity.class)
                .setParameter("idGroup", idGroup)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .getResultList();

        Long total = entityManager.createQuery(countStr, Long.class)
                .setParameter("idGroup", idGroup)
                .getSingleResult();

        return new ListWithCount<>(result, total);
    }

    @Override
    public ListWithCount<LetterEntity> findAll(int page, int pageSize) {
        String queryStr = "SELECT l FROM LetterEntity l";
        String countStr = "SELECT COUNT(l) FROM LetterEntity l";

        List<LetterEntity> result = entityManager.createQuery(queryStr, LetterEntity.class)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .getResultList();

        Long total = entityManager.createQuery(countStr, Long.class)
                .getSingleResult();

        return new ListWithCount<>(result, total);
    }

    @Override
    public Optional<LetterEntity> findById(String id) {
        String query = "SELECT l FROM LetterEntity l " +
                "LEFT JOIN FETCH l.user u " +
                "LEFT JOIN FETCH l.group g " +
                "WHERE l.id = :idLetter";
        try {
            return Optional.of(entityManager.createQuery(query, LetterEntity.class)
                    .setParameter("idLetter", id)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void save(LetterEntity letter) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            UserEntity userEntity = entityManager.getReference(UserEntity.class, letter.getUser().getIdUser());
            letter.setUser(userEntity);
            for (ProductEntity product : letter.getProducts()) {
                product.setLetter(letter);
            }
            if (letter.getIdLetter() == null) {
                entityManager.persist(letter);
            } else {
                entityManager.merge(letter);
            }

            transaction.commit();
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
            LetterEntity letter = entityManager.find(LetterEntity.class, id);
            if (letter != null) {
                entityManager.remove(letter);
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
