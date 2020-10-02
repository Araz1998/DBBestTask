package DB;

import DB.ConnectionFactory;
import javafx.util.Pair;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SetPointsDAO {
    final static String CREATE_TABLE_SETPOINTS = "CREATE TABLE IF NOT EXISTS setPoints (" +
            "IDA VARCHAR ," +
            "IDB VARCHAR ) AS SELECT * FROM CSVREAD " +
            "('C://Users//Араз//IdeaProjects//DbBestTask//src//main//resources//setPoints.csv')";

    final static String SELECT_SYSTEM = "SELECT * FROM setPoints";
    public static List<Pair<String, String>> pairs = new ArrayList<>();

    public void createTableSetPoints () {
        try (Connection connection = ConnectionFactory.getConnectionDB()){
            Statement statement = connection.createStatement();
            statement.executeUpdate(CREATE_TABLE_SETPOINTS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectSetPoints(){
        try(Connection connection = ConnectionFactory.getConnectionDB()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_SYSTEM);
            while (resultSet.next()){
                String idA = resultSet.getString(1);
                String idB = resultSet.getString(2);
                pairs.add(new Pair<>(idA, idB));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
