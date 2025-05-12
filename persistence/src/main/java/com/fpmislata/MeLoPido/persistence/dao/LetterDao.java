package com.fpmislata.MeLoPido.persistence.dao;

import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.LetterEntity;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;


public interface LetterDao extends GenericDao<LetterEntity> {
    ListWithCount<LetterEntity> findAllByUser(int page, int pageSize, String idUser);
    ListWithCount<LetterEntity> findAllByGroup(int page, int pageSize, String idGroup);
}
