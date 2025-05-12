package com.fpmislata.MeLoPido.persistence.dao.jpa;

import com.fpmislata.MeLoPido.persistence.dao.LetterDao;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.LetterEntity;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class LetterDaoJpa implements LetterDao {
    @PersistenceContext
    private final EntityManager entityManager;

    public LetterDaoJpa(EntityManager entityManager){
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
    @Transactional
    public void save(LetterEntity letter) {
        if (letter.getIdLetter() == null) {
            String sql = "INSERT INTO letters (description, creation_date, send_date, expiration_date, id_user, id_group) " +
                    "VALUES (:description, :creationDate,  :idUser)";
            entityManager.createNativeQuery(sql)
                    .setParameter("description", letter.getDescription())
                    .setParameter("creationDate", letter.getCreationDate())
                    .setParameter("idUser", letter.getUser().getIdUser())
                    .executeUpdate();

        } else {
            entityManager.merge(letter);
        }
    }

    @Override
    public void delete(String id) {
        LetterEntity letter = entityManager.find(LetterEntity.class, id);
        if (letter != null) {
            entityManager.remove(letter);
        }
    }
}
