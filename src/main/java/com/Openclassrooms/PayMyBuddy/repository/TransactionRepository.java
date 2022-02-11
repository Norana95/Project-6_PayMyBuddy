package com.Openclassrooms.PayMyBuddy.repository;

import com.Openclassrooms.PayMyBuddy.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
