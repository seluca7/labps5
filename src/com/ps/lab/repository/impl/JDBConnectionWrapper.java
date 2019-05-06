package com.ps.lab.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBConnectionWrapper {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final int TIMEOUT = 5;

    private Connection connection;

    public JDBConnectionWrapper(String schemaName) {
        try {
            connection = DriverManager.getConnection(DB_URL + schemaName + "?useSSL=false", USER, PASS);
            createTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTables() throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS user (" +
                "  id BIGINT(100) NOT NULL AUTO_INCREMENT," +
                "  username varchar(255) NOT NULL," +
                "  password varchar(255) NOT NULL," +
                "  admin BOOLEAN not null, "+
                "  PRIMARY KEY (id)," +
                "  UNIQUE KEY id_UNIQUE (id)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;";
        statement.execute(sql);

        String sql2 = "CREATE TABLE IF NOT EXISTS book (" +
                "  id BIGINT(100) NOT NULL AUTO_INCREMENT," +
                "  title varchar(255) NOT NULL," +
                "  author varchar(255) NOT NULL," +
                "  genre varchar(255) NOT NULL," +
                "  price DOUBLE NOT NULL," +
                "  quantity BIGINT(100) NOT NULL," +
                "  PRIMARY KEY (id)," +
                "  UNIQUE KEY id_UNIQUE (id)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;";
        statement.execute(sql2);

        String sql3 = "CREATE TABLE IF NOT EXISTS shopping_basket (" +
                "  id BIGINT(100) NOT NULL AUTO_INCREMENT," +
                "  user_id BIGINT(100) NOT NULL," +
                "  PRIMARY KEY (id)," +
                "  UNIQUE KEY id_UNIQUE (id)," +
                "  FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE" +
                ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;";
        statement.execute(sql3);

        String sql4 = "CREATE TABLE IF NOT EXISTS shopping_basket_book (" +
                "  id BIGINT(100) NOT NULL AUTO_INCREMENT," +
                "  shopping_basket_id BIGINT(100) NOT NULL," +
                "  carte_id BIGINT(100) NOT NULL," +
                "  cantitate int(10) NOT NULL," +
                "  PRIMARY KEY (id)," +
                "  UNIQUE KEY id_UNIQUE (id)," +
                "  FOREIGN KEY (shopping_basket_id) REFERENCES shopping_basket(id) ON DELETE CASCADE," +
                "  FOREIGN KEY (carte_id) REFERENCES book(id) ON DELETE CASCADE" +
                ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;";
        statement.execute(sql4);

    }

    public boolean testConnection() throws SQLException {
        return connection.isValid(TIMEOUT);
    }

    public Connection getConnection() {
        return connection;
    }

}
