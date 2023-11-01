package com.atividadeLoja.atividadeLoja.repository;

import com.atividadeLoja.atividadeLoja.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>, CustomQuerydslPredicateExecutor<Fornecedor> {
}
