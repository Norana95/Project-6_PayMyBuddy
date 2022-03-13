package com.Openclassrooms.PayMyBuddy.serviceUnitTest;

import com.Openclassrooms.PayMyBuddy.model.FriendShip;
import com.Openclassrooms.PayMyBuddy.model.User;
import com.Openclassrooms.PayMyBuddy.repository.FriendShipRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class FriendShipTest {

    @Autowired
    FriendShipRepository friendShipRepository;

    @Test
    void addFriendShip() {
        User userConnected = new User("testUserF", "testUserL", "testUser@test.com","testUserP");
        User friend = new User("testFriendF", "testFriendL", "testFriend@test.com","testFriendP");
        FriendShip friendShip = new FriendShip();
        friendShip.setUser(userConnected);
        friendShip.setFriend(friend);
        friendShipRepository.save(friendShip);
        Assertions.assertThat(friendShip.getId()).isGreaterThanOrEqualTo(1);
    }
}
