package com.mbrull.repository;

import org.springframework.stereotype.Repository;

import com.mbrull.entities.SubCategory;

@Repository
public interface ExpenseRepository extends BaseRepository<SubCategory, Long> {

}