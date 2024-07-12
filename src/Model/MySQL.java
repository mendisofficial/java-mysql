package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class MySQL {

    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad-test", "root", "root");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet execute(String query) throws Exception {
        Statement statement = connection.createStatement();

        if (query.startsWith("SELECT")) {
            ResultSet resultset = statement.executeQuery(query);
            return resultset;
        } else {
            int result = statement.executeUpdate(query);
            return null;
        }

    }
}
