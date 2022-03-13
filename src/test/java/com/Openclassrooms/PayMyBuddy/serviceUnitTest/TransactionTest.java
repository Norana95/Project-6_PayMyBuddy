package com.Openclassrooms.PayMyBuddy.serviceUnitTest;

import com.Openclassrooms.PayMyBuddy.model.Transaction;
import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.repository.TransactionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class TransactionTest {

    @Autowired
    TransactionRepository transactionRepository;


    @Test
    void saveTransactionTest() {
        User sender = new User(100, "testSenderF", "testSenderL", "testSender@test.com", "testSenderP");
        User receiver = new User(20, "testReceiverF", "testReceiverL", "testReceiver@test.com", "testReceiverP");
        Transaction transaction = new Transaction(20, sender, receiver);
        transactionRepository.save(transaction);
        Assertions.assertThat(transaction.getId()).isGreaterThan(0);
    }

    @Test
    void getAllTransaction() {
        User sender = new User(100, "testSenderF", "testSenderL", "testSender@test.com", "testSenderP");
        User receiver = new User(20, "testReceiverF", "testReceiverL", "testReceiver@test.com", "testReceiverP");
        Transaction transaction = new Transaction(20, sender, receiver);
        transactionRepository.save(transaction);
        List<Transaction> transactionList = (List<Transaction>) transactionRepository.findAll();
        Assertions.assertThat(transactionList.size()).isGreaterThan(0);
    }
    @Test
    void getAllTransactionEmptyList() {
        List<Transaction> transactionList = (List<Transaction>) transactionRepository.findAll();
        Assertions.assertThat(transactionList.size()).isEqualTo(0);
    }

}
