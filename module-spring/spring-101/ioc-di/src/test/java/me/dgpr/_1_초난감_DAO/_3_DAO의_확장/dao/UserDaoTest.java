package me.dgpr._1_초난감_DAO._3_DAO의_확장.dao;

import java.util.UUID;
import me.dgpr._1_초난감_DAO._3_DAO의_확장.data.User;
import org.junit.jupiter.api.Test;

public class UserDaoTest {

    @Test
    void user를_생성하여_db에_삽입한다() throws Exception {
        //Arrange
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(UUID.randomUUID().toString());
        user.setPassword(UUID.randomUUID().toString());

        UserDao dao = new UserDao(new ConnectionMakerImpl());

        //Act //Assert
        dao.add(user);
    }
}
