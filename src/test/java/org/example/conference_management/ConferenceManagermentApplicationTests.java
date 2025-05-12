package org.example.conference_management;

import org.example.conference_management.pojo.user;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConferenceManagermentApplicationTests {

    @Test
    void contextLoads() {
        user u = new user();
        System.out.println(u.getEmail());
    }

}
