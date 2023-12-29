package me.dgpr._1_초난감_DAO._4_IoC.connection;

import java.sql.Connection;

public interface ConnectionMaker {
    Connection makeConnection() throws ClassNotFoundException, java.sql.SQLException;
}
