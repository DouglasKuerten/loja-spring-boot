package com.atividadeLoja.atividadeLoja.repository;

import com.atividadeLoja.atividadeLoja.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long>, CustomQuerydslPredicateExecutor<Locacao> {
}
