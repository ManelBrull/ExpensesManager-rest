package com.mbrull.persistence.repository;

import org.springframework.stereotype.Repository;

import com.mbrull.persistence.entities.Category;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long> {

}