package ru.muzafarov.lesson15date20191202.inno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreationMain {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    Class.forName("org.postgresql.Driver");
    Connection connection = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/mobile",
        "postgres",
        "qwerty");
    Statement statement = connection.createStatement();
    statement.execute("-- Database: mobile\n"
        + "DROP TABLE IF EXISTS mobile;"
        + "CREATE TABLE mobile (\n"
        + "    id bigserial primary key,\n"
        + "    model varchar(100) NOT NULL,\n"
        + "    price integer NOT NULL,\n"
        + "    manufacturer varchar(100) NOT NULL);"
        + "\n"
        + "INSERT INTO mobile (model, price, manufacturer)\n"
        + "VALUES\n"
        + "   ('P1', 100, 'Xiaomi'),\n"
        + "   ('EDGE', 1, 'Micro'),\n"
        + "   ('FRY1', 1001, 'Apple'),\n"
        + "   ('FRY1', 1002, 'Apple'),\n"
        + "   ('OGO', 10000, 'SAMSUNG');");
    connection.close();
  }
}
