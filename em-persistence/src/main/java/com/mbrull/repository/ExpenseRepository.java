package com.mbrull.repository;

import org.springframework.stereotype.Repository;

import com.mbrull.entities.Expense;

@Repository
public interface ExpenseRepository extends BaseRepository<Expense, Long> {

}