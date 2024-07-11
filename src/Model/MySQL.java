package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class MySQL {
    public static ResultSet execute(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad-test", "root", "root");
            Statement statement = connection.createStatement();
            
            if (query.startsWith("SELECT")) {
                ResultSet resultset = statement.executeQuery(query);
                return resultset;
            } else {
                int result = statement.executeUpdate(query);
                return null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
