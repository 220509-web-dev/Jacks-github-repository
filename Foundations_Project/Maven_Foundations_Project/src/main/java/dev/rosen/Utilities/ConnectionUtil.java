package dev.rosen.Utilities;
//ask wezley about factory design pattern and instance method
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static void main(String[] args){
        System.out.println(getConnection());
    }

    public static Connection getConnection() {

        try {
            //jdbc:postgresql://host/dbname?user=username&password=userpassword switch url back to dbinfo
            String dbInfo = System.getenv("DB_connection");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/postgres?user=postgres&password=revature");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}