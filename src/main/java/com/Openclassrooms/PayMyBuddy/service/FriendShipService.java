package com.Openclassrooms.PayMyBuddy.service;

import com.Openclassrooms.PayMyBuddy.model.FriendShip;
import com.Openclassrooms.PayMyBuddy.repository.FriendShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendShipService {

    @Autowired
    FriendShipRepository friendShipRepository;

    public void addFriendShip(FriendShip friendShip){
        friendShipRepository.save(friendShip);
    }
}
