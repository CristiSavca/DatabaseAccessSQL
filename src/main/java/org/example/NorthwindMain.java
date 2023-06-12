package org.example;

import java.sql.*;

public class NorthwindMain {
    public static void main(String[] args) {
        String driverClassname = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/northwind";

        Connection connection = null;

        try{
            connection = DriverManager.getConnection(url, "cristi", "2424");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet results = null;

            results = statement.executeQuery("SELECT * FROM Products");

            while (results.next()){
                String name = results.getString("ProductName");
                System.out.println(name);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}