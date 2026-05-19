package com.mateusgromowski.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/sistema_bibliotecario";
        String userName = "admin";
        String pwd = "senha123";
        Connection conn = DriverManager.getConnection(url, userName, pwd);
        return conn;
    }
}
