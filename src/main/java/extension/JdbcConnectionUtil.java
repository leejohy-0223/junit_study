package extension;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionUtil {

    private static Connection connection;
    private static String url = "jdbc:h2:~/extension;AUTO_SERVER=TRUE";
    private static String id = "sa";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, id, "");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return connection;
        }
        return connection;
    }
}
