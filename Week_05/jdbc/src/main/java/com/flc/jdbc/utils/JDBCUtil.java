package com.flc.jdbc.utils;

import java.sql.*;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/18 16:21
 * @desc
 */
public class JDBCUtil {
    static final String JDBC_DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/java_training_camp?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PWD = "root";

    public static void loadDriver() {
        try {
            Class.forName(JDBC_DRIVER_CLASS_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            loadDriver();
            connection = DriverManager.getConnection(URL, USER,PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void release(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void release(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        release(statement, connection);
    }




}
