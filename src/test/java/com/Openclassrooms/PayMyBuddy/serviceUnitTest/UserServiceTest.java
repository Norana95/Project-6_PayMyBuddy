package com.Openclassrooms.PayMyBuddy.serviceUnitTest;

import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.repository.UserRepository;
import com.Openclassrooms.PayMyBuddy.service.UserService;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void initData() {
        userRepository.delete(userService.getUserByUsername("usernameTest@test.com"));
    }

    @Test
    void saveUserWithEncoderPasswordTest() {
        ///given
        User userTest = new User("firstnameTest", "lastnameTest", "usernameTest@test.com", "passwordTest");
        //when
        userService.saveUserWithEncoderPassword(userTest);
        //then
        Assertions.assertNotNull(userRepository.getUserByUsername(userTest.getUsername()));
    }
    @Test
    void getUserByUsernameTest() {
        User userTest = new User("firstnameTest", "lastnameTest", "usernameTest@test.com", "passwordTest");
        userService.saveUserWithEncoderPassword(userTest);
        Assertions.assertEquals(userService.getUserByUsername(userTest.username).firstName,"firstnameTest");
    }
    @Test
    void saveUserTest(){
        User userTest = new User("firstnameTest", "lastnameTest", "usernameTest@test.com", "passwordTest");
        userService.saveUser(userTest);
        Assertions.assertNotNull(userService.getUserByUsername("usernameTest@test.com"));
    }


}
