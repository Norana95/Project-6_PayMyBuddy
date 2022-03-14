package com.Openclassrooms.PayMyBuddy.controller;

import com.Openclassrooms.PayMyBuddy.constant.FareOfTransaction;
import com.Openclassrooms.PayMyBuddy.model.Transaction;
import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.service.CalculTransaction;
import com.Openclassrooms.PayMyBuddy.service.TransactionService;
import com.Openclassrooms.PayMyBuddy.service.UserService;
import com.Openclassrooms.PayMyBuddy.model.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//le controller fait appelle à la couche service
@Controller
public class TransactionController {

    @Autowired
    UserService userService;
    @Autowired
    TransactionService transactionService;
    @Autowired
    CalculTransaction calculTransaction;


    @GetMapping("/addconnection")
    public String showAddConnectionPage() {
        return "addconnection";
    }

    @PostMapping("/transfert")
    public String addTransaction(String connection, int amount) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUserDetails connectedUser = (MyUserDetails) principal;
        User userConnected = userService.getUserByUsername(connectedUser.getUsername());
        User receiver = userService.getUserByUsername(connection);
        transactionService.calculateBalanceAndSaveTransaction(amount, receiver,userConnected);
        return "redirect:/transfert";
    }

    @GetMapping("/transfert")
    public String showTransfertPage(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUserDetails connectedUser = (MyUserDetails) principal;
        User user = userService.getUserByUsername(connectedUser.getUsername());
        model.addAttribute("friendsList", user.getFriends());
        model.addAttribute("transactions", user.getTransactions());
        return "transfert";
    }

    @PostMapping("/balance")
    public String deposit(int amount) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUserDetails connectedUser = (MyUserDetails) principal;
        User user = userService.getUserByUsername(connectedUser.getUsername());
        user.setBalance(user.getBalance() + amount);
        userService.saveUser(user);
        return "redirect:/balance";
    }
}

