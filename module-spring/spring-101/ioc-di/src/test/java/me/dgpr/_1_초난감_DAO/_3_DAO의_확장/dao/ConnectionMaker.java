package me.dgpr._1_초난감_DAO._3_DAO의_확장.dao;

import java.sql.Connection;

public interface ConnectionMaker {
    Connection makeConnection() throws ClassNotFoundException, java.sql.SQLException;
}
