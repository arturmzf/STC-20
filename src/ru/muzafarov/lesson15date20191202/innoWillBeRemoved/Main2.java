package ru.muzafarov.lesson15date20191202.innoWillBeRemoved;

import java.sql.*;

public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/mobile",
                "postgres",
                "qwerty");

        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        for (int i = 0; i < 4; i++) {
            statement.executeUpdate(
                "INSERT INTO mobile (model, price, manufacturer)\n"
                    + "VALUES\n"
                    + "   ('G" + i + "', " + i + ", 'SAMSUNG');"
            );
        }
        connection.commit();
        connection.close();
    }
}
