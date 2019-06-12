/*
 * Gokhan Has - 161044067
 */

/**
 * This is the Edge Class.
 * @author gokhanHas
 */
public class Edge {
    /**
     * keeping destination as an Integer referance.
     */
    private Integer dest;

    /**
     * keeping source as an Integer referance.
     */
    private Integer source;

    /**
     * Graph can be weighted graph.
     */
    private double weight;

    /**
     * This is the two parameters constructor.
     * @param paramSource int source
     * @param paramDest int destination
     */
    public Edge(int paramSource,int paramDest) {
        source = paramSource;
        dest = paramDest;
    }

    /**
     * This is the three parameters constructor.
     * @param paramSource int source
     * @param paramDest int destination
     * @param paramWeight double weight
     */
    public Edge(int paramSource,int paramDest,double paramWeight) {
        source = paramSource;
        dest = paramDest;
        weight = paramWeight;
    }

    /**
     *
     * @param o an an Object referance
     * @return true if two refarance's source and dest are equal, otherwise false.
     */
    public boolean equals(Object o) {
        if(o instanceof Edge)
            return ( (this.source == ((Edge)o).source) && ((this.dest == ((Edge)o).dest)));

        return false;
    }

    /**
     *
     * @return destination as an int.
     */
    public int getDest() {
        return dest;
    }

    /**
     *
     * @return source as an int.
     */
    public int getSource() {
        return source;
    }

    /**
     *
     * @return weight as a double.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Convert String dest and source and added two's variable.
     * @return int hashCode
     */
    public int hashCode() {
        return ((dest.toString() + source.toString()).hashCode());
    }


    public String toString() {
        return String.format("Source : " + source + "     Destination : " + dest);
    }
}
