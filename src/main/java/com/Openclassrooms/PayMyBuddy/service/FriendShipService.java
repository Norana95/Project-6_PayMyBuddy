package com.Openclassrooms.PayMyBuddy.service;

import com.Openclassrooms.PayMyBuddy.model.FriendShip;
import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.repository.FriendShipRepository;
import com.Openclassrooms.PayMyBuddy.service.impl.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendShipService {

    @Autowired
    FriendShipRepository friendShipRepository;
    @Autowired
    UserService userService;

    public void addFriendShip(User friend) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUserDetails connectedUser = (MyUserDetails) principal;
        User user = userService.getUserByUsername(connectedUser.getUsername());
        FriendShip friendShip = new FriendShip();
        friendShip.setUser(user);
        friendShip.setFriend(friend);
        friendShipRepository.save(friendShip);
    }

    public List<User> findFriendsByUser(User user) {
        return user.getFriends();
    }

}