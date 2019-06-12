/*
 * Gokhan Has - 161044067
 */

/**
 * This is the myGraph interface.
 * @author gokhanHas
 */

import java.util.Iterator;

public interface myGraph {

    /**
     *
     * @return numberOfVertex in graph.
     */
    int getNumV();

    /**
     *
     * @return true if graph is directed.
     */
    boolean isDirected();

    /**
     * Insert new Edge referance to graph.
     * @param edge is an Edge referance.
     */
    void insert(Edge edge);

    /**
     *
     * @param source int source
     * @param dest int destination
     * @return true if graph has an specific Edge.
     */
    boolean isEdge(int source,int dest);

    /**
     *
     * @param source int source
     * @param dest int destination
     * @return Edge referance as given Edge's parameters.
     */
    Edge getEdge(int source,int dest);

    /**
     *
     * @param source
     * @return the Iterator of the given source.
     */
    Iterator<Edge> edgeIterator(int source);
}
