package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepoTest {
    @Autowired
    private UserRepository userRepository;

    private static final User USER = new User("Sam", "test@gmail.com");

    @Test
    void saveUser() {
        User user = userRepository.save(USER);

        assertEquals(USER, user);
    }

    @Test
    void findById() {
        User user = userRepository.save(USER);
        User foundUser = userRepository.findById(user.getId()).orElse(null);

        assertEquals(user, foundUser);
    }
}
