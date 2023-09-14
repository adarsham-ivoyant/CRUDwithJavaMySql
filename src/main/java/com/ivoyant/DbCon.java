package com.ivoyant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbCon {
    private static final Logger logger = LoggerFactory.getLogger(DbCon.class);
    public static Connection connection;
    public static void conn(){
        String url = "jdbc:mysql://localhost:3306/employee";
        try {
            connection = DriverManager.getConnection(url,"root","12345678");
            logger.info(connection + " successfully Connected");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
