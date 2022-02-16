package com.Openclassrooms.PayMyBuddy.controller;

import com.Openclassrooms.PayMyBuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//le controller fait appelle à la couche service
@Controller
public class TransactionController {

    @Autowired
    UserService userService;

    @GetMapping("/addconnection")
    public String showAddConnectionPage() {
        return "addconnection";
    }

}
