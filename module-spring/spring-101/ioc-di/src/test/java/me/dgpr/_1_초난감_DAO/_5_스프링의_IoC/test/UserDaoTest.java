package me.dgpr._1_초난감_DAO._5_스프링의_IoC.test;

import java.util.UUID;
import me.dgpr._1_초난감_DAO._5_스프링의_IoC.dao.UserDao;
import me.dgpr._1_초난감_DAO._5_스프링의_IoC.data.User;
import me.dgpr._1_초난감_DAO._5_스프링의_IoC.factory.DaoFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class UserDaoTest {

    @Test
    void user를_생성하여_db에_삽입한다() throws Exception {
        //Arrange
        User user = getUser();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                DaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);

        //Act //Assert
        dao.add(user);
    }

    private User getUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(UUID.randomUUID().toString());
        user.setPassword(UUID.randomUUID().toString());
        return user;
    }
}
