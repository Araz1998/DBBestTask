package DB;

import DB.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OutputDAO {
    private static final String CREATE_TABLE_OUTPUT ="CREATE TABLE IF NOT EXISTS output(" +
            "ROUTE_EXISTS VARCHAR," +
            "MIN_LENGTH INT)" +
            " AS SELECT * FROM CSVREAD (('C://Users//Араз//IdeaProjects//DbBestTask//src//main//resources//result.csv'))";

    public void createTableInput () {
        try (Connection connection = ConnectionFactory.getConnectionDB()){
            Statement statement = connection.createStatement();
            statement.executeUpdate(CREATE_TABLE_OUTPUT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
