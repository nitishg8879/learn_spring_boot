package com.AOP.aopTest.JPA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public Connection getConnection() {
        try {
            Class.forName("my.sql.jdbc.Driver");
            return DriverManager.getConnection("", "sa", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
