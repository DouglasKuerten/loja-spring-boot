package com.atividadeLoja.atividadeLoja.repository;
import com.atividadeLoja.atividadeLoja.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>, CustomQuerydslPredicateExecutor<Compra> {
}
