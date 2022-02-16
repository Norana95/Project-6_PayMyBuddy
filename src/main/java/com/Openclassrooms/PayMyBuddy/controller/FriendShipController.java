package com.Openclassrooms.PayMyBuddy.controller;

import com.Openclassrooms.PayMyBuddy.model.FriendShip;
import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.service.FriendShipService;
import com.Openclassrooms.PayMyBuddy.service.impl.MyUserDetails;
import com.Openclassrooms.PayMyBuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FriendShipController {

    @Autowired
    UserService userService;

    @Autowired
    FriendShipService friendShipService;

    @PostMapping("/addconnection")
    public String addFriend(String email) throws Exception {
        /*
        User friend = (User) userService.loadUserByUsername(email);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User connectedUser = (User) principal;
        User user = (User) userService.loadUserByUsername(connectedUser.getUsername());*/
        User friend = userService.getUserByUsername(email);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUserDetails connectedUser = (MyUserDetails) principal;
        User user = userService.getUserByUsername(connectedUser.getUsername());
        FriendShip friendShip = new FriendShip();
        friendShip.setUser(user);
        friendShip.setFriend(friend);
        friendShipService.addFriendShip(friendShip);
        return "transfert";
    }
}
