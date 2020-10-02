import DB.OutputDAO;
import DB.PipelineDAO;
import DB.SetPointsDAO;
import DijkstraAlgoritm.Graph;
import javafx.util.Pair;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Applicatiion {
    static Logger LOGGER;
    public void start(){
        LOGGER = Logger.getLogger(Main.class.getName());
        PipelineDAO pipelineDAO = new PipelineDAO();
        SetPointsDAO setPoints = new SetPointsDAO();
        OutputDAO outputDAO = new OutputDAO();
        LOGGER.log(Level.INFO, "Creation tables");
        pipelineDAO.createTableInput();
        setPoints.createTableSetPoints();
        LOGGER.log(Level.INFO, "All tables have created");
        setPoints.selectSetPoints();
        pipelineDAO.selectSystem();

        LOGGER.log(Level.INFO, "Searching the shortest way");
        Graph.Edge[] graphMsss = pipelineDAO.GRAPH.toArray(new Graph.Edge[0]);
        Graph graph = new Graph(graphMsss);

//        for (Pair<String, String> s : SetPointsDAO.pairs){
//            graph.dijkstra(s.getKey());
//            graph.printPath(s.getValue());
//        }
        outputDAO.createTableInput();
        LOGGER.log(Level.INFO, "Successfully, end of works!");
    }

}
