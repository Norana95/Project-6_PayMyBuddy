package com.Openclassrooms.PayMyBuddy.service;

import com.Openclassrooms.PayMyBuddy.model.Transaction;
import com.Openclassrooms.PayMyBuddy.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
    public Iterable<Transaction> getAllTransaction(){
       return transactionRepository.findAll();
    }

}
