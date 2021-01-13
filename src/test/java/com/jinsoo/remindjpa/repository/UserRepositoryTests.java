package com.jinsoo.remindjpa.repository;

import com.jinsoo.remindjpa.model.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
public class UserRepositoryTests {

//   Log4j는 기본적으로 Spring boot에 내장되어 있는것인가.
//   따로 library를 가져오지 않았는데도 쓸 수 있다는 것을 확인했다.
    private Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTests.class);

    @Autowired
    private UserRepository userRepository;

    @Test
    @DirtiesContext
//    DirtiesContext를 해줬기 떄문에 다른 Test과는
//    독립적으로 테스트 할 수 있었다.
    public void insertTest() {

        User insertedUser = new User();
        insertedUser.setId(1L);
        insertedUser.setUserName("test");
        insertedUser.setUserPassword("test-password");

        userRepository.insertUser(insertedUser);

        User selectedUser = userRepository.findById(1L);
        LOGGER.info("selected user ==>  {}", selectedUser);

    }

    @Test
    @DirtiesContext
    public void insertTest2(){
        User insertedUser = new User();
        insertedUser.setId(1L);
        insertedUser.setUserName("test");
        insertedUser.setUserPassword("test-password");

        userRepository.insertUser(insertedUser);

        User selectedUser = userRepository.findById(1L);
        LOGGER.info("selected user ==>  {}", selectedUser);
    }



}
