package com.fpmislata.MeLoPido.persistence.dao.jpa.repository;

import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductJpaRepository extends JpaRepository<ProductEntity,String> {
    @Query(value = "SELECT * FROM products WHERE assigned_to = :idUser", nativeQuery = true)
    Page<ProductEntity> findAllAssignedToUser(@Param("idUser") String idUser, Pageable pageable);
}
