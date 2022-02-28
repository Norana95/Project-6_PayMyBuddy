package com.Openclassrooms.PayMyBuddy.controllerIT;

import com.Openclassrooms.PayMyBuddy.controller.FriendShipController;
import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.repository.UserRepository;
import com.Openclassrooms.PayMyBuddy.service.FriendShipService;
import com.Openclassrooms.PayMyBuddy.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FriendShipController.class)
public class FriendShipControllerIT {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    UserService userService;

    //ajout d'un ami ;
    @Test
    void addFriendTest() throws Exception {
        User user = new User("userFirstname", "userLastname", "user@gmail.com", "userPassword");
        userService.saveUserWithEncoderPassword(user);
        this.mockMvc.perform(post("/addconnection").accept(MediaType.ALL_VALUE).param("email", (user.username))).andExpect(status().isOk());
    }

}
