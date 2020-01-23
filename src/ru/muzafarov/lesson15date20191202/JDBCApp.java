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

    public static void main(String[] args) {
        try {
            JDBCApp.doingPreparedStatement();
            JDBCApp.doingBatch();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Main Method Complete!");
        }
    }

    // Параметризированный запрос
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

    // Batch-процесс
    public static void doingBatch() throws SQLException, ClassNotFoundException{
        // Для чего эта строчка?
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();
        statement.addBatch("INSERT INTO person(name, birthday, login, city, email, description) " +
            "VALUES(\"Музафаров Артур Ринатович\"," +
            "new Date(17/04/1992)," +
            "\"arturmzf\"," +
            "\"Kazan\"," +
            "\"artur.mzf@gmail.com\"," +
            "\"Cool Man\")");
        statement.addBatch("INSERT INTO person(name, birthday, login, city, email, description) " +
                "VALUES(\"Музафаров Ринат Абрарович\"," +
                "new Date(13/08/1957)," +
                "\"rinatmzf\"," +
                "\"Zelenodolsk\"," +
                "\"rinat.mzf@gmail.com\"," +
                "\"Father of Cool Man\")");
        statement.addBatch("INSERT INTO person(name, birthday, login, city, email, description) " +
                "VALUES(\"Музафарова Кадрия Акрамовна\"," +
                "new Date(11/05/1960)," +
                "\"kadriyamzf\"," +
                "\"Zelenodolsk\"," +
                "\"kadriya.mzf@gmail.com\"," +
                "\"Mother of Cool Man\")");
        int[] result = statement.executeBatch();
        statement.close();
        connection.close();
    }
}
