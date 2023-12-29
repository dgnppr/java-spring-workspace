package me.dgpr._1_초난감_DAO._5_스프링의_IoC.factory;

import me.dgpr._1_초난감_DAO._5_스프링의_IoC.connection.ConnectionMaker;
import me.dgpr._1_초난감_DAO._5_스프링의_IoC.connection.ConnectionMakerImpl;
import me.dgpr._1_초난감_DAO._5_스프링의_IoC.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        return new UserDao(getConnectionMaker());
    }

    @Bean
    public ConnectionMaker getConnectionMaker() {
        return new ConnectionMakerImpl();
    }
}
