/*
 * Gokhan Has - 161044067
 */

/**
 * This is the main class.
 * @author gokhanHas
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mainClass {

    public static void main(String[] args) throws FileNotFoundException {

        graphMatrix matrixGraph = readFile("input.txt");
        System.out.println("Popular Count : " + matrixGraph.calculatePopularity());
        System.out.println();
        matrixGraph.drawGraphMatrix();

    }

    /**
     *
     * @param fileName is txt filename.Must be in src folder.
     * @return graphMatrix referance.
     * @throws FileNotFoundException if File not found.
     */
    public static graphMatrix readFile(String fileName) throws FileNotFoundException {

        graphMatrix matrixGraph = null;

        Scanner reader = new Scanner(new File("./src/" + fileName));
        boolean firstControl = true;
        while (reader.hasNext()){

            if(firstControl) {

                matrixGraph = new graphMatrix(reader.nextInt(),true);
                int totalEdgeNumber = reader.nextInt();

                firstControl = false;
            }
            else {
                Edge newEdge = new Edge(reader.nextInt(),reader.nextInt());
                matrixGraph.insert(newEdge);
            }
        }

        return matrixGraph;
    }
}
