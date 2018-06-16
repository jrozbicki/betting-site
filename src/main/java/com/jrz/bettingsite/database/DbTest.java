package com.jrz.bettingsite.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbTest {
    public static void main(String[] args) {

        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            e.printStackTrace();
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/bettingsite_db?useSSL=false","bettingsite", "bet123");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("Connections established!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }
}
