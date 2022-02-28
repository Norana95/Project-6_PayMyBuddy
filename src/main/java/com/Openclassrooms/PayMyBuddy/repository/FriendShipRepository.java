package com.Openclassrooms.PayMyBuddy.repository;

import com.Openclassrooms.PayMyBuddy.model.FriendShip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendShipRepository extends CrudRepository<FriendShip, Long> {
}
