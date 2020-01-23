package ru.muzafarov.lesson15date20191202.innoWillBeRemoved;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main4 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        args = new String[]{"1", "2"};

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/mobile",
                "postgres",
                "qwerty");
        PreparedStatement preparedStatement = connection.prepareStatement(
                "update mobile set price=5000 where id = ?");
        for (String arg : args) {
            preparedStatement.setInt(1, Integer.parseInt(arg));
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.close();
    }
}
