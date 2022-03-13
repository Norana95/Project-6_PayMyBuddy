package com.Openclassrooms.PayMyBuddy.repositoryUnitTest;

import com.Openclassrooms.PayMyBuddy.model.Transaction;
import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.repository.TransactionRepository;
import com.Openclassrooms.PayMyBuddy.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void getUserByUsernameTest() {
        User user = new User(100, "testSenderF", "testSenderL", "testSender@test.com", "testSenderP");
        userRepository.save(user);
        userRepository.getUserByUsername(user.username);
        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }
}
