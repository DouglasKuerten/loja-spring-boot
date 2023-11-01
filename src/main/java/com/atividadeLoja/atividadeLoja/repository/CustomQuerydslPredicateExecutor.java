package com.atividadeLoja.atividadeLoja.repository;

import com.atividadeLoja.atividadeLoja.enterprise.BooleanBuilderUtil;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface CustomQuerydslPredicateExecutor <T> extends QuerydslPredicateExecutor<T> {
    @Override
    List<T> findAll(Predicate predicate);

    default List<T> findAll(String filter, Class<T> entityType){
        BooleanBuilder booleanBuilder = BooleanBuilderUtil.buildPredicateFromFilter(filter, entityType);
        return this.findAll(booleanBuilder);
    }
}
