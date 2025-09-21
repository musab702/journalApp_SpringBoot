package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.util.Strings;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @ParameterizedTest
    @ValueSource(strings = {
            "ram",
            "madara",
            "hashirama",
            "bingus"
    })
    public void testfindByUserName(String name){

        assertNotNull(userRepository.findByUsername(name), "failed for:" + name);
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,2",
            "2,2,4",
            "2,3,6",
            "4,2,8",
            "5,2,10",

    })
    public void test(int a, int b, int expected){
        assertEquals(expected, a*b);
    }

}
