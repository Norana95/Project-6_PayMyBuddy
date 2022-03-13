package com.Openclassrooms.PayMyBuddy.controller;

import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.service.FriendShipService;
import com.Openclassrooms.PayMyBuddy.service.UserService;
import com.Openclassrooms.PayMyBuddy.model.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FriendShipController {

    @Autowired
    UserService userService;

    @Autowired
    FriendShipService friendShipService;

    @PostMapping("/addconnection")
    public String addFriend(String email, Model model) {
        User friend = userService.getUserByUsername(email);
        if (friend == null) {
            model.addAttribute("userNull", "this user doesn't exist");
            return "addconnection";
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUserDetails connectedUser = (MyUserDetails) principal;
        User userConnected = userService.getUserByUsername(connectedUser.getUsername());
        friendShipService.addFriendShip(friend, userConnected);
        userConnected.getFriends().add(friend);
        userService.saveUser(userConnected);
        return "redirect:/transfert";
    }


}
