package com.fpmislata.MeLoPido.persistence.dao.jpa;

import com.fpmislata.MeLoPido.persistence.dao.UserDao;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.UserEntity;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserDaoJpa implements UserDao {
    private final EntityManager entityManager;

    public UserDaoJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ListWithCount<UserEntity> findAllByGroup(int page, int pageSize, String idGroup) {
        String queryStr = "SELECT u FROM UserEntity u JOIN u.groups g WHERE g.id = :idGroup";
        String countStr = "SELECT COUNT(DISTINCT u) FROM UserEntity u JOIN u.groups g WHERE g.id = :idGroup";

        List<UserEntity> result = entityManager.createQuery(queryStr, UserEntity.class)
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
    public Optional<UserEntity> findByUsername(String username) {
        String query = "SELECT u FROM UserEntity u WHERE u.username = :username";
        try {
            return Optional.of(entityManager.createQuery(query, UserEntity.class)
                    .setParameter("username", username)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserEntity> findByProductId(String idProduct) {
        //TODO: acabar
        String query = "SELECT u FROM UserEntity u";
        try {
            return Optional.of(entityManager.createQuery(query, UserEntity.class)
                    .setParameter("idProduct", idProduct)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public ListWithCount<UserEntity> findAll(int page, int pageSize) {
        String queryStr = "SELECT u FROM UserEntity u";
        String countStr = "SELECT COUNT(u) FROM UserEntity u";

        List<UserEntity> result = entityManager.createQuery(queryStr, UserEntity.class)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .getResultList();

        Long total = entityManager.createQuery(countStr, Long.class)
                .getSingleResult();

        return new ListWithCount<>(result, total);
    }

    @Override
    public Optional<UserEntity> findById(String id) {
        String query = "SELECT u FROM UserEntity u WHERE u.id = :idUser";
        try {
            return Optional.of(entityManager.createQuery(query, UserEntity.class)
                    .setParameter("idUser", id)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public String save(UserEntity user) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            if (user.getIdUser() == null || user.getIdUser().isEmpty()) {
                user.setIdUser(UUID.randomUUID().toString());
            }
            UserEntity managedUser = entityManager.merge(user);

            transaction.commit();
            return managedUser.getIdUser();
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

            UserEntity user = entityManager.find(UserEntity.class, id);
            if (user != null) {
                entityManager.remove(user);
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
