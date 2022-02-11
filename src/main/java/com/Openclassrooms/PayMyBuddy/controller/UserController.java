package com.Openclassrooms.PayMyBuddy.controller;

import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.service.UserService;
import com.Openclassrooms.PayMyBuddy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//le controller fait appelle à la couche service
@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    //voir la page inscription
    @GetMapping("/signup")
    public String showSignUpForm() {
        return "sign_up";
    }

    //enregistrement du user dans la base de données
    @PostMapping("/adduser")
    public String addUser(@Validated User user, BindingResult result) {
        if (result.hasErrors()) {
            return "sign_in";
        }
        userService.saveUser(user);
        return "register_success";
    }

    // voir la page login
    @GetMapping("/signin")
    public String showSignInForm() {
        return "login";
    }

    //voir la page transfert
    @GetMapping("/transfert")
    public String showTransfertPage() {
        return "transfert";
    }

}
