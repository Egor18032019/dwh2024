package org.dwh.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MasterOfTables {
    Statement stmt;
    Connection conn;
    String[] columnsName;

    public MasterOfTables() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5555/dwh", "postgres", "postgres");
            stmt = conn.createStatement();
            String sequence = "CREATE SEQUENCE global_seq START WITH 100000;";
            stmt.executeUpdate(sequence);
            String dropTable = "DROP TABLE IF EXISTS tableName;";
            stmt.executeUpdate(dropTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName, String[] columns) throws SQLException {
        columnsName = columns;
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE IF NOT EXISTS ")
                .append("tableName")
                .append(" ( ")
                .append("ID SERIAL PRIMARY KEY,");
        for (int i = 0; i < columns.length; i++) {
            builder.append(columns[i].toLowerCase()).append(" VARCHAR(255)");
            if (i != columns.length - 1) {
                builder.append(",");
            }
        }
        builder.append(");");
        String createTableQuery = builder.toString();
        System.out.println("Запрос создания таблицы: " + createTableQuery);
        stmt.executeUpdate(createTableQuery);
        System.out.println("Таблица успешно создана.");

    }

    // Заполнение таблицы данными
    public void insertData(String tableName, String[] columns) throws SQLException {
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO ")
                .append("tableName")
                .append(" ( ");
        for (int i = 0; i < columnsName.length; i++) {
            builder.append(columnsName[i].toLowerCase());
            if (i != columns.length - 1) {
                builder.append(",");
            }
        }
        builder.append(") VALUES (");
        for (int i = 0; i < columns.length; i++) {
            builder.append(columns[i]);
            if (i != columns.length - 1) {
                builder.append(",");
            }
        }
        builder.append(");");
        String insertQuery = builder.toString();
        System.out.println("Запрос добавления данных: " + insertQuery);
        stmt.executeUpdate(insertQuery);
        System.out.println("Данные успешно добавлены.");
    }

    public void close() throws SQLException {
        // Закрытие соединения
        conn.close();
    }
}
