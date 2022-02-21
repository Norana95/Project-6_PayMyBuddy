package com.Openclassrooms.PayMyBuddy.repository;

import com.Openclassrooms.PayMyBuddy.model.FriendShip;
import com.Openclassrooms.PayMyBuddy.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendShipRepository extends CrudRepository<FriendShip, Long> {

}
