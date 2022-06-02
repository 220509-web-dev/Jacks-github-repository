package com.revature.quizzzard.utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory connectionFactory;

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }

    static {
        try {
            class.forname("org.postgresql.Driver");
            throw new RuntimeException(e);//another fail fast

        }
    }

    private Properties props = new Properties();
    private ConnectionFactory() {
        try {
            props.load(new FileReader("src/main/resources/application.properties"));
        } catch (Exception e) {
            System.err.println("Failed to load database credentials from property file.");
            throw  new RuntimeException(e); // fails fast for easy debugging
        }
    }

    public Connection getConnection() throws SQLException {

        Connection conn = DriverManager.getConnection(props.getProperty("db-url"),
        props.getProperty("db-username"),
               props.getProperty("db-password") );
    }
}
