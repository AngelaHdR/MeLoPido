package com.fpmislata.MeLoPido.persistence.dao.jpa;

import com.fpmislata.MeLoPido.persistence.dao.GroupDao;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.GroupEntity;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class GroupDaoJpa implements GroupDao {
    private final EntityManager entityManager;

    public GroupDaoJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ListWithCount<GroupEntity> findAllByUser(int page, int pageSize, String idUser) {
        String queryStr = "SELECT g FROM GroupEntity g JOIN g.users u WHERE u.id = :idUser";
        String countStr = "SELECT COUNT(g) FROM GroupEntity g JOIN g.users u WHERE u.id = :idUser";

        List<GroupEntity> result = entityManager.createQuery(queryStr, GroupEntity.class)
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
    public ListWithCount<GroupEntity> findAll(int page, int pageSize) {
        String queryStr = "SELECT g FROM GroupEntity g";
        String countStr = "SELECT COUNT(g) FROM GroupEntity g";

        List<GroupEntity> result = entityManager.createQuery(queryStr, GroupEntity.class)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .getResultList();

        Long total = entityManager.createQuery(countStr, Long.class)
                .getSingleResult();

        return new ListWithCount<>(result, total);
    }

    @Override
    public Optional<GroupEntity> findById(String id) {
        String query = "SELECT g FROM GroupEntity g WHERE g.id = :idGroup";
        try {
            return Optional.of(entityManager.createQuery(query, GroupEntity.class)
                    .setParameter("idGroup", id)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void save(GroupEntity group) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            if (group.getIdGroup() == null) {
                entityManager.persist(group);
            } else {
                entityManager.merge(group);
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

            GroupEntity group = entityManager.find(GroupEntity.class, id);
            if (group != null) {
                entityManager.remove(group);
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
