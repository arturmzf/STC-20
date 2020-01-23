/**
 * Занятие № 14 [от 29.11.2019 (Пт)]
 * Занятие № 15 [от 02.12.2019 (Пн)]
 *
 * Темы:
 * - JDBC и работа с БД
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson15date20191202;

import java.sql.*;

public class JDBCApp {
    private final static String DATABASE_URL = "jdbc:postgresql://localhost:5432/persons";
    private final static String DATABASE_LOGIN = "postgres";
    private final static String DATABASE_PASSWORD = "postgres";
    private final static String SQL_INSERT =
            "INSERT INTO person(name, birthday, login, city, email, description) VALUES(?, ?, ?, ?, ?, ?)";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

    }

    public static void doingPreparedStatement() throws SQLException, ClassNotFoundException{
        // Для чего эта строчка?
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);

        preparedStatement.setString(1, "Музафаров Артур Ринатович");
        preparedStatement.setDate(2, new Date(17/04/1992));
        preparedStatement.setString(3, "arturmzf");
        preparedStatement.setString(4, "Kazan");
        preparedStatement.setString(5, "art.mzf@gmail.com");
        preparedStatement.setString(6, "Cool Man");

        connection.close();
    }

    public static void doingBatch() throws SQLException, ClassNotFoundException{
        // Для чего эта строчка?
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);

        preparedStatement.setString(1, "Музафаров Артур Ринатович");
        preparedStatement.setDate(2, new Date(17/04/1992));
        preparedStatement.setString(3, "arturmzf");
        preparedStatement.setString(4, "Kazan");
        preparedStatement.setString(5, "art.mzf@gmail.com");
        preparedStatement.setString(6, "Cool Man");

        connection.close();
    }
}
