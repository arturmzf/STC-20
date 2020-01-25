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
    private final static String SQL_SELECT =
            "SELECT * FROM person WHERE id = ? and name = ?";

    public static void main(String[] args) {
        try {
            JDBCApp.doingPreparedStatement();
            JDBCApp.doingBatch();
            JDBCApp.doingPreparedSelect();
            JDBCApp.nonAutoCommit();
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

        preparedStatement.execute();
        preparedStatement.close();
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
                "VALUES(\"Самохвалов Юрий Григорьевич\"," +
                "new Date(11/12/1935)," +
                "\"samohvalov.yu.g\"," +
                "\"Zelenodolsk\"," +
                "\"yuriy.samohvalov@gmail.com\"," +
                "\"no description\")");
        statement.addBatch("INSERT INTO person(name, birthday, login, city, email, description) " +
                "VALUES(\"Деточкин Юрий Иванович\"," +
                "new Date(04/02/1950)," +
                "\"detochkin.yu.i\"," +
                "\"Vladivostok\"," +
                "\"yuriy.detochkin@mail.ru\"," +
                "\"no description\")");
        statement.addBatch("INSERT INTO person(name, birthday, login, city, email, description) " +
                "VALUES(\"Огудалова Лариса Дмитриевна\"," +
                "new Date(28/07/1970)," +
                "\"ogudalova.l.d\"," +
                "\"Ryazan\"," +
                "\"larisa.ogudalova@ya.ru\"," +
                "\"no description\")");
        int[] result = statement.executeBatch();
        statement.close();
        connection.close();
    }

    // Параметризированная выборка по login_ID и name одновременно
    public static void doingPreparedSelect() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT);
        preparedStatement.setInt(1, 1);
        preparedStatement.setString(2, "Иванов Иван Иванович");
        preparedStatement.setInt(1, 3);
        preparedStatement.setString(2, "Калугина Людмила Прокофьевна");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.print("ID = " + resultSet.getInt("id"));
            System.out.print("; name = " + resultSet.getString("name"));
            System.out.print("; birthday = " + resultSet.getDate("birthday"));
            System.out.print("; login = " + resultSet.getString("login"));
            System.out.print("; city = " + resultSet.getString("city"));
            System.out.print("; email = " + resultSet.getString("email"));
            System.out.println("; description = " + resultSet.getString("description"));
        }
        preparedStatement.close();
        connection.close();
    }

    // Перевод connection в ручное управление транзакциями
    public static void nonAutoCommit() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_LOGIN, DATABASE_PASSWORD);
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();

        // Запись № 1
        statement.executeUpdate(
                "INSERT INTO person(name, birthday, login, city, email, description) " +
                        "VALUES(\"Лукашин Евгений Михайлович\"," +
                        "new Date(18/11/1942)," +
                        "\"lukashin.e.m\"," +
                        "\"Stavropol\"," +
                        "\"evgeniy.lukashin@mail.ru\"," +
                        "\"no description\"));"
        );

        // Запись № 2
        statement.executeUpdate(
                "INSERT INTO roles(name, description) " +
                        "VALUES(\"администратор\"," +
                        "\"no description\"));"
        );

        // Запись № 3
        statement.executeUpdate(
                "INSERT INTO roles(name, description) " +
                        "VALUES(\"пользователь\"," +
                        "\"no description\"));"
        );

        // Запись № 4
        statement.executeUpdate(
                "INSERT INTO user_roles(user_id, role_id) " +
                        "VALUES(1, 1));"
        );

        // Установка Savepoint
        Savepoint savepointA = connection.setSavepoint("A");

        // Запись № 5 - НЕКОРРЕКТНАЯ!
        statement.executeUpdate(
                "INSERT INTO user_roles(user_id, role_id) " +
                        "VALUES(700, 800));"
        );

        // Rollback
        connection.rollback(savepointA);

        // Commit
        connection.commit();

        statement.close();
        connection.close();
    }
}
