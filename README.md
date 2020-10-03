# DBBestTask

This is a test task, from DB Best

# Description task

It's a water pipeline system We use three parameters to describe it: starting point id,
endpoint id, and pipe length.
Your goal is to create a Java application which answers the following questions:
1) Does the route between two points (id-A and id-B) exist?
2) If the answer is yes, then calculate the minimal route length between id-A and id-B.

# Input

Have two CSV files, System.csv describe our water pipeline system, and setPoints.csv file with a set of points, between which you
need to find the route.

# Output

For these two input files, this application generates result result.csv.

Application's CLI type. Has three packages: 
- DB, for all Java-classes what workings with DB;
- DiijkstraAlgoritm, has one class, that make all operation, for searching a shortest way to pipeline
system.
- resources, has three CSV filles: System.csv has 3 parametrs ( idX; idY; lenght), describe the water pipeline system; setPoints.csv has 2 parametrs (idA, idB), 
it's a file with a set of points, between which need to find the route; And result.csv has 2 parametrs ( Route exists, min length).  
 
 Also, in project has two classes: Application, has one function start(), that creates all objects that needs. And Main class, 
that launching Application's function.










