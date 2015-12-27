package com.mbrull.persistence.repository;

import org.springframework.stereotype.Repository;

import com.mbrull.persistence.entities.Expense;

@Repository
public interface ExpenseRepository extends BaseRepository<Expense, Long> {

}