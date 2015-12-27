package com.mbrull.persistence.repository;

import org.springframework.stereotype.Repository;

import com.mbrull.persistence.entities.Subcategory;

@Repository
public interface SubcategoryRepository extends BaseRepository<Subcategory, Long> {

}