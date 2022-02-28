package com.Openclassrooms.PayMyBuddy.controller;

import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.service.FriendShipService;
import com.Openclassrooms.PayMyBuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FriendShipController {

    @Autowired
    UserService userService;

    @Autowired
    FriendShipService friendShipService;

    @PostMapping("/addconnection")
    public String addFriend(@RequestParam String email, Model model) {
        User friend = userService.getUserByUsername(email);
        if(friend==null){
            model.addAttribute("userNull", "this user doesn't exist");
            return "addconnection";
        }
        else {
            friendShipService.addFriendShip(friend);
        }
        return "redirect:/transfert";
    }



}
