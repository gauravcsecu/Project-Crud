package com.example.latestapplication.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setEmail("gp13081999@gmail.com");
        user.setPassword("gauravpandey");
        user.setLastName("panda");
        user.setFirstName("gaurav");

        User saveuser = userRepository.save(user);
        Assertions.assertEquals(saveuser.getFirstName(),"gaurav");
        List<User> userlist = userRepository.findAll();
        System.out.println("size of user list "+userlist.size());
    }
}
