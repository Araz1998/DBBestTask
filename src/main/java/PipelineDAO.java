import java.sql.*;

public class PipelineDAO {
   private final static String SELECT_PIPELINESYSTEM = "SELECT * FROM pipelineSystem";
   private final static String SELECT_SYSTEM = "SELECT * FROM SYSTEM";
   private final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS pipelineSystem(" +
            "IDA INT ," +
            "IDB INT ," +
            "lenght INT ) AS SELECT * FROM CSVREAD" +
            " ('C://Users//Араз//IdeaProjects//DbBestTask//src//main//resources//System.csv')";

   private final static String CREATE_TABLE_SET = "CREATE TABLE IF NOT EXISTS system (" +
            "IDA INT," +
            "IDB INT) AS SELECT * FROM CSVREAD " +
            "('C://Users//Араз//IdeaProjects//DbBestTask//src//main//resources//setPoints.csv')";


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

//
//           while (resultSet.next()){
//               String idA = resultSet.getString(1);
//               String idB = resultSet.getString(2);
//               int length = resultSet.getInt(3);
//                Graph.Edge graph = new Graph.Edge(idA, idB, length);
//           }

       } catch (SQLException e) {
           e.printStackTrace();
       }

   }


}
