import javafx.util.Pair;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    final static String SELECT_PIPELINESYSTEM = "SELECT * FROM pipelineSystem";
    final static String SELECT_SYSTEM = "SELECT * FROM SYSTEM";
    final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS pipelineSystem(" +
            "IDA VARCHAR ," +
            "IDB VARCHAR ," +
            "lenght INT ) AS SELECT * FROM CSVREAD" +
            " ('C://Users//Араз//IdeaProjects//DbBestTask//src//main//resources//System.csv')";

    final static String CREATE_TABLE_SET = "CREATE TABLE IF NOT EXISTS system (" +
            "IDA VARCHAR ," +
            "IDB VARCHAR ) AS SELECT * FROM CSVREAD " +
            "('C://Users//Араз//IdeaProjects//DbBestTask//src//main//resources//setPoints.csv')";



    static List<Pair<String, String>> pairs = new ArrayList<>();
    static List<Graph.Edge> GRAPH = new ArrayList<>();

    public static void main(String[] args)  {
        try(Connection connection = ConnectionFactory.getConnectionDB();
            Statement statement = connection.createStatement()){
            System.out.println("Connected!");
            System.out.println("Creation table....");
            statement.executeUpdate(CREATE_TABLE);
            statement.executeUpdate(CREATE_TABLE_SET);
            System.out.println("Created!");
            ResultSet resultSet = statement.executeQuery(SELECT_PIPELINESYSTEM);
            while (resultSet.next()){

                String idA = resultSet.getString(1);
                String idB = resultSet.getString(2);
                int length = resultSet.getInt(3);
                Graph.Edge edge = new Graph.Edge(idA, idB, length);
                GRAPH.add(edge);
            }
            for (Graph.Edge e : GRAPH){
                System.out.println(e);
            }

            resultSet = statement.executeQuery(SELECT_SYSTEM);
            while (resultSet.next()){
                String idA = resultSet.getString(1);
                String idB = resultSet.getString(2);
                pairs.add(new Pair<>(idA, idB));
            }

            System.out.println("~~~~~~~~~");
            for (Pair<String, String> s : pairs){
             System.out.println(s);
            }

            System.out.println("~~~~~~~~~~~");
            Graph.Edge[] graphMsss = GRAPH.toArray(new Graph.Edge[0]);
            Graph graph = new Graph(graphMsss);

            for (Pair<String, String> s : pairs){
                graph.dijkstra(s.getKey());
                graph.printPath(s.getValue());
            }

            System.out.println("!!EEEENNNNDDD!!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
