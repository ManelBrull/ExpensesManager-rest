package com.mbrull.repository;

import org.springframework.stereotype.Repository;

import com.mbrull.entities.Category;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long> {

}