package com.Openclassrooms.PayMyBuddy.controller;

import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.service.UserService;
import com.Openclassrooms.PayMyBuddy.model.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//le controller fait appelle à la couche service
@Controller
public class UserController {

    @Autowired
    UserService userService;

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
        userService.saveUserWithEncoderPassword(user);
        return "register_success";
    }
    @GetMapping("/login")
    public String showSignInForm() {
        return "login";
    }

    @GetMapping("/balance")
    public String getBalanceUser(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUserDetails connectedUser = (MyUserDetails) principal;
        User user = userService.getUserByUsername(connectedUser.getUsername());
        model.addAttribute("balanceZero", "Your balance is : " + user.getBalance() + " €");
        return "balance";
    }
}
