package com.Openclassrooms.PayMyBuddy.serviceUnitTest;

import com.Openclassrooms.PayMyBuddy.model.Transaction;
import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.repository.TransactionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class TransactionTest {

    @Autowired
    TransactionRepository transactionRepository;

    public Transaction transaction;

    @BeforeEach
    public void createDataUser(){
        User sender = new User(100, "testSenderF", "testSenderL", "testSender@test.com", "testSenderP");
        User receiver = new User(20, "testReceiverF", "testReceiverL", "testReceiver@test.com", "testReceiverP");
        transaction = new Transaction(20, sender, receiver);
        transactionRepository.save(transaction);
    }

    @Test
    void saveTransactionTest() {
        Assertions.assertThat(transaction.getId()).isGreaterThan(0);
    }

    @Test
    void getAllTransaction() {
        List<Transaction> transactionList = (List<Transaction>) transactionRepository.findAll();
        Assertions.assertThat(transactionList.size()).isGreaterThan(0);
    }
    @Test
    void getAllTransactionEmptyList() {
        List<Transaction> transactionList = (List<Transaction>) transactionRepository.findAll();
        Assertions.assertThat(transactionList.size()).isEqualTo(0);
    }

}
