package ru.vsu.cs.baturin_v_a.repository.database;

import java.sql.*;

public class DatabaseManagerImpl implements DatabaseManager {
    private final String url;
    private final String user;
    private final String password;

    private Connection connection;
    private static DatabaseManagerImpl instance;

    private DatabaseManagerImpl() {
        url = "jdbc:postgresql://localhost:8888/java-pl";
        user = "postgres";
        password = "admin";
    }

    public static DatabaseManagerImpl getInstance() {
        if (instance == null)
            instance = new DatabaseManagerImpl();
        return instance;
    }

    @Override
    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public int executeUpdate(String sql) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            rows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password); //соединение с БД
            System.out.println("Соединение с СУБД выполнено.");
        } catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        } catch (ClassNotFoundException clnfe){
            System.out.println("драйвер не найден");
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void closeConnection() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
