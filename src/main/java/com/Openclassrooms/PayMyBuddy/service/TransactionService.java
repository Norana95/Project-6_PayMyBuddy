package com.Openclassrooms.PayMyBuddy.service;

import com.Openclassrooms.PayMyBuddy.constant.FareOfTransaction;
import com.Openclassrooms.PayMyBuddy.model.Transaction;
import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    UserService userService;
    @Autowired
    CalculTransaction calculTransaction;


    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public Iterable<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }
    public void calculateBalanceAndSaveTransaction(int amount, User receiver, User userConnected){
        if (receiver != null && !(userConnected.getBalance() - amount < FareOfTransaction.fare)) {
            double result = calculTransaction.transactionCalculationWithPercentage(amount);
            userConnected.setBalance(userConnected.getBalance() - result);
            receiver.setBalance(receiver.getBalance() + amount);
            Transaction transaction = new Transaction();
            transaction.setSender(userConnected);
            transaction.setReceiver(receiver);
            transaction.setAmount(amount);
            userConnected.getTransactions().add(transaction);
            userService.saveUser(userConnected);
            userService.saveUser(receiver);
        }
    }
}
