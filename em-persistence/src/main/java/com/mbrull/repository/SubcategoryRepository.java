package com.mbrull.repository;

import org.springframework.stereotype.Repository;

import com.mbrull.entities.Subcategory;

@Repository
public interface SubcategoryRepository extends BaseRepository<Subcategory, Long> {

}