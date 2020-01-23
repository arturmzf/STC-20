package ru.muzafarov.lesson15date20191202.innoWillBeRemoved;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5433/mobile",
            "postgres",
            "qwerty");

        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT * FROM mobile WHERE model = ? and price < ?");
        preparedStatement.setString(1, "FRY1");
        preparedStatement.setFloat(2, 2000);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.print("model=" + resultSet.getString("model"));
            System.out.print("; price=" + resultSet.getInt("price"));
            System.out.println("; manufecturer=" + resultSet.getString(
                "manufacturer"));
        }
        connection.close();
    }
}
