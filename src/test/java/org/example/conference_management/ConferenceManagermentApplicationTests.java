package org.example.conference_management;

import org.example.conference_management.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConferenceManagermentApplicationTests {

    @Test
    void contextLoads() {
        User u = new User();
        System.out.println(u.getEmail());
    }

}
