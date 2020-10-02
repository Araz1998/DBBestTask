package DB;

import DB.ConnectionFactory;
import DijkstraAlgoritm.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PipelineDAO {
   public static List<Graph.Edge> GRAPH = new ArrayList<>();

   private final static String SELECT_PIPELINESYSTEM = "SELECT * FROM pipelineSystem";
   private final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS pipelineSystem(" +
            "IDA INT ," +
            "IDB INT ," +
            "lenght INT ) AS SELECT * FROM CSVREAD" +
            " ('C://Users//Араз//IdeaProjects//DbBestTask//src//main//resources//System.csv')";

   public void createTableInput () {
       try (Connection connection = ConnectionFactory.getConnectionDB()){
           Statement statement = connection.createStatement();
           statement.executeUpdate(CREATE_TABLE);
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

   public void selectSystem(){
       try (Connection connection = ConnectionFactory.getConnectionDB()){
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(SELECT_PIPELINESYSTEM);
           while (resultSet.next()){
               String idA = resultSet.getString(1);
               String idB = resultSet.getString(2);
               int length = resultSet.getInt(3);
               Graph.Edge edge = new Graph.Edge(idA, idB, length);
               GRAPH.add(edge);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
}
