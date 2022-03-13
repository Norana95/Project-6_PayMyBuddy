package com.Openclassrooms.PayMyBuddy.controllerIT;

import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.repository.UserRepository;
import com.Openclassrooms.PayMyBuddy.service.CalculTransaction;
import com.Openclassrooms.PayMyBuddy.service.FriendShipService;
import com.Openclassrooms.PayMyBuddy.service.TransactionService;
import com.Openclassrooms.PayMyBuddy.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class UserControllerIT {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserService userService;
    @MockBean
    FriendShipService friendShipService;
    @MockBean
    TransactionService transactionService;
    @MockBean
    CalculTransaction calculTransaction;
    @MockBean
    UserRepository userRepository;

    @Test
    void showSignUpForm() throws Exception {
        this.mockMvc.perform(get("/signup")).andExpect(status().isOk()).andReturn();
    }
    @Test
    void showSignInFormTest() throws Exception {
        this.mockMvc.perform(get("/login")).andExpect(status().isOk()).andReturn();
    }

}
