package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL =
         "jdbc:postgresql://ep-broad-firefly-ao1zov5j-pooler.c-2.ap-southeast-1.aws.neon.tech/neondb?sslmode=require";
    private static final String USER =
            "neondb_owner";

    private static final String PASSWORD =
            "npg_CYD8dQ2bzLxs";

    public static Connection getConnection() throws Exception {

        Class.forName("org.postgresql.Driver");

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}