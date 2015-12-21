package com.mbrull.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID>, JpaSpecificationExecutor<T> {

    void delete(T deleted);

    Page<T> findAll(Pageable pageRequest);

    Optional<T> findOne(ID id);

    T save(T persisted);

    long count();

    void flush();

}
