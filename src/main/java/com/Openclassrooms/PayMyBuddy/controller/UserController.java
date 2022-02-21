package com.Openclassrooms.PayMyBuddy.controller;

import com.Openclassrooms.PayMyBuddy.model.FriendShip;
import com.Openclassrooms.PayMyBuddy.model.Transaction;
import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.service.TransactionService;
import com.Openclassrooms.PayMyBuddy.service.UserService;
import com.Openclassrooms.PayMyBuddy.service.impl.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

//le controller fait appelle à la couche service
@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    TransactionService transactionService;

    //voir la page inscription
    @GetMapping("/signup")
    public String showSignUpForm() {
        return "sign_up";
    }

    //enregistrement du user dans la base de données
    @PostMapping("/adduser")
    public String addUser(@Validated User user, BindingResult result) {
        if (result.hasErrors() || userService.getUserByUsername(user.getUsername()) != null) {
            return "sign_up"; // mettre un message qui dit que le user existe déja.
        }
        userService.saveUser(user);
        return "register_success";
    }

    @GetMapping("/home")
    public String showSignInForm() {
        return "index";
    }

    @GetMapping("/transfert")
    public String showTransfertPage(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUserDetails connectedUser = (MyUserDetails) principal;
        User user = userService.getUserByUsername(connectedUser.getUsername());
        List<User> friendsList = user.getFriends();
        model.addAttribute("friendsList", friendsList);
        model.addAttribute("transactions", transactionService.getAllTransaction());
        return "transfert";
    }

}
