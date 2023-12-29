package me.dgpr._1_초난감_DAO._4_IoC.factory;

import me.dgpr._1_초난감_DAO._4_IoC.connection.ConnectionMaker;
import me.dgpr._1_초난감_DAO._4_IoC.connection.ConnectionMakerImpl;
import me.dgpr._1_초난감_DAO._4_IoC.dao.UserDao;

public class DaoFactory {
    public UserDao userDao() {
        return new UserDao(getConnectionMaker());
    }

    private ConnectionMaker getConnectionMaker() {
        return new ConnectionMakerImpl();
    }
}
