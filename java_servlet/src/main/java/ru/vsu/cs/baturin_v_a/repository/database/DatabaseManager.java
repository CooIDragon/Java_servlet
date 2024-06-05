package ru.vsu.cs.baturin_v_a.repository.database;

import java.sql.Connection;
import java.sql.ResultSet;

public interface DatabaseManager {
    ResultSet executeQuery(String sql);
    int executeUpdate(String sql);
    Connection getConnection();
    void closeConnection();
    void connect();
}
