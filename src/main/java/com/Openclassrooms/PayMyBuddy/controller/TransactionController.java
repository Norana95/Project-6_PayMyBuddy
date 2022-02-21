package com.Openclassrooms.PayMyBuddy.controller;

import com.Openclassrooms.PayMyBuddy.model.Transaction;
import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.service.TransactionService;
import com.Openclassrooms.PayMyBuddy.service.UserService;
import com.Openclassrooms.PayMyBuddy.service.impl.MyUserDetails;
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

    @GetMapping("/addconnection")
    public String showAddConnectionPage() {
        return "addconnection";
    }

    @PostMapping("/addtransaction")
    public String addTransaction(String email, int amount, Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUserDetails connectedUser = (MyUserDetails) principal;
        User userConnected = userService.getUserByUsername(connectedUser.getUsername());
        User receiver = userService.getUserByUsername(email);

        if(userConnected.getBalance()<amount){
            return "transfert";
        }
        else {
            userConnected.setBalance(userConnected.getBalance()-amount);
            receiver.setBalance(receiver.getBalance()+amount);
            Transaction transaction = new Transaction();
            transaction.setSender(userConnected);
            transaction.setReceiver(receiver);
            transaction.setAmount(amount);
            transactionService.saveTransaction(transaction);
        }
        return "transfert";
    }
}
