package me.dgpr._1_초난감_DAO._2_DAO의_분리.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class NUserDao extends UserDao {

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        // N사 DB Connection 생성코드
        return null;
    }
}
