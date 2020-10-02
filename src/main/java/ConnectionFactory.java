import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnectionDB() throws SQLException {
        String url = "jdbc:h2:~/test";
        String userPassword = "";
        String userName = "root";
        return DriverManager.getConnection(url, userName, userPassword);
    }
}
