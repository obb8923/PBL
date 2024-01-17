package team2.PBL_AD_Manager.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team2.PBL_AD_Manager.domain.Gender;
import team2.PBL_AD_Manager.domain.User;
import team2.PBL_AD_Manager.repository.UserRePository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRePository userRePository;

    @Test
    void 유저_등록(){
        User user1 = new User();
        user1.setAge(20);
        user1.setGender(Gender.female);

        User user2 = new User();
        user2.setAge(10);
        user2.setGender(Gender.male);

        userService.save(user1);
        userService.save(user2);

        User findUser1 = userService.findOne(user1.getId());
        User findUser2 = userService.findOne(user2.getId());

        Assertions.assertThat(findUser1.getAge()).isEqualTo(user1.getAge());

    }
}