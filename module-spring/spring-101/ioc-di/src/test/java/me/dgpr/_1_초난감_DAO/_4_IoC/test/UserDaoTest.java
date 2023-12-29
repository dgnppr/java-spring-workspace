package me.dgpr._1_초난감_DAO._4_IoC.test;

import java.util.UUID;
import me.dgpr._1_초난감_DAO._4_IoC.dao.UserDao;
import me.dgpr._1_초난감_DAO._4_IoC.data.User;
import me.dgpr._1_초난감_DAO._4_IoC.factory.DaoFactory;
import org.junit.jupiter.api.Test;

public class UserDaoTest {

    @Test
    void user를_생성하여_db에_삽입한다() throws Exception {
        //Arrange
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(UUID.randomUUID().toString());
        user.setPassword(UUID.randomUUID().toString());

        UserDao dao = new DaoFactory().userDao();

        //Act //Assert
        dao.add(user);
    }
}
