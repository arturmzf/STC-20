package ru.muzafarov.lesson15date20191202.inno;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/mobile",
                "postgres",
                "qwerty");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM mobile");

        while (resultSet.next()) {
            System.out.print("model=" + resultSet.getString("model"));
            System.out.print("; price=" + resultSet.getInt("price"));
            System.out.println("; manufecturer=" + resultSet.getString("manufacturer"));
        }
        connection.close();
    }
}
