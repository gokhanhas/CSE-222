/*
 * Gokhan Has - 161044067
 */

/**
 * This is the graphAdt abstract class.
 * @author gokhanHas
 */

public abstract class graphADT implements myGraph {
    /**
     * keeping graph's directed status as a boolean.
     */
    private boolean directed;

    /**
     * keeping graphs's number of Vertex as an int.
     */
    private int numVertex;

    /**
     * This is the constructor.
     * @param paramNumVertex
     * @param paramDirected
     */
    public graphADT(int paramNumVertex, boolean paramDirected) {
        directed = paramDirected;
        numVertex = paramNumVertex;
    }

    /**
     *
     * @return graph's number of Vertex.
     */
    public int getNumV(){
        return numVertex;
    }

    /**
     *
     * @return graphs directed status.
     */
    public boolean isDirected(){
        return directed;
    }
}
