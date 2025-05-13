package com.fpmislata.MeLoPido.persistence.dao.jpa;

import com.fpmislata.MeLoPido.domain.model.Product;
import com.fpmislata.MeLoPido.persistence.dao.ProductDao;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.LetterEntity;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.ProductEntity;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class ProductDaoJpa implements ProductDao {
    private final EntityManager entityManager;

    public ProductDaoJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ListWithCount<ProductEntity> findAllAssignedToUser(int page, int pageSize, String idUser) {
        String queryStr = "SELECT p FROM ProductEntity p WHERE p.asignado.id = :idUser";
        String countStr = "SELECT COUNT(p) FROM ProductEntity p WHERE p.asignado.id = :idUser";

        List<ProductEntity> result = entityManager.createQuery(queryStr, ProductEntity.class)
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
    public ListWithCount<ProductEntity> findAll(int page, int pageSize) {
        String queryStr = "SELECT p FROM ProductEntity p";
        String countStr = "SELECT COUNT(p) FROM ProductEntity p";

        List<ProductEntity> result = entityManager.createQuery(queryStr, ProductEntity.class)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .getResultList();

        Long total = entityManager.createQuery(countStr, Long.class)
                .getSingleResult();

        return new ListWithCount<>(result, total);
    }

    @Override
    public Optional<ProductEntity> findById(String id) {
        String query = "SELECT p FROM ProductEntity p " + "WHERE p.id = :idProduct";
        try {
            return Optional.of(entityManager.createQuery(query, ProductEntity.class)
                    .setParameter("idProduct", id)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void save(ProductEntity product) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            if (product.getIdProduct() == null) {
                entityManager.persist(product);
            } else {
                entityManager.merge(product);
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

            ProductEntity product = entityManager.find(ProductEntity.class, id);
            if (product != null) {
                entityManager.remove(product);
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
