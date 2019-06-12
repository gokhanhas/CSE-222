/*
 * Gokhan Has - 161044067
 */

/**
 * This is the graphMatrix class. All operations are here.
 * @uthor gokhanHas.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class graphMatrix extends graphADT{

    /**
     * keeping vertex and destination as a 2D array boolean.
     */
    private boolean[][] array2D;

    /**
     * This is the constructor.
     * @param paramNumVertex
     * @param paramDirected
     */
    public graphMatrix(int paramNumVertex, boolean paramDirected) {
        super(paramNumVertex, paramDirected);
        array2D = new boolean[paramNumVertex][paramNumVertex];
    }


    @Override
    public void insert(Edge edge) {
        array2D[edge.getSource()-1][edge.getDest()-1] = true;
        if(!isDirected())
            array2D[edge.getDest()-1][edge.getSource()-1] = true;
    }

    @Override
    public boolean isEdge(int source, int dest) {

        if(source > array2D.length || dest > array2D[0].length || source <= 0 || dest <= 0)
            throw new IndexOutOfBoundsException();

        if(array2D[source-1][dest-1] == true)
            return true;
        return false;
    }

    @Override
    public Edge getEdge(int source, int dest) {

        if(source > array2D.length || dest > array2D[0].length || source <= 0 || dest <= 0)
            throw new IndexOutOfBoundsException();

        if(array2D[source-1][dest-1] == true)
            return new Edge(source,dest);

        return null;
    }

    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return new MatrixIterator(source);
    }

    private class MatrixIterator implements Iterator<Edge>, Iterable<Edge> {

        private int source;
        private int dest = 0;

        MatrixIterator(int src) {
            this.source = src;
        }

        @Override
        public Iterator<Edge> iterator() {
            return this;
        }

        @Override
        public boolean hasNext() {
            while(dest < array2D[source].length) {
                if(array2D[source-1][dest] == true)
                    return true;
                dest++;
            }
            return false;
        }

        @Override
        public Edge next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            dest++;
            return new Edge(source,dest);
        }
    }

    /**
     * It marked transtive.
     */
    private void findTranstive() {

        for (int k = 0; k < this.getNumV(); k++) {
            for (int i = 0; i < this.getNumV(); i++) {
                for (int j = 0; j < this.getNumV(); j++) {

                    if((array2D[i][j] == true) || ((array2D[i][k] == true) && (array2D[k][j]== true)))
                        array2D[i][j] = true;
                    else
                        array2D[i][j] = false;
                }
            }
        }
    }

    /**
     *
     * @return popularity number.
     */
    public int calculatePopularity() {

        this.findTranstive();

        int[] vertexNumberArray = new int[this.getNumV()];
        int popularCount = 0;

        for(int i=0; i < this.getNumV(); ++i) {
            for(int j=0; j < this.getNumV(); ++j) {

                if( (array2D[i][j] == true) && (i != j)) {
                    vertexNumberArray[j]++;
                }
            }
        }

        for(int i=0; i< vertexNumberArray.length; ++i){

            if(vertexNumberArray[i] == this.getNumV() - 1)
                popularCount++;
        }

        return popularCount;
    }

    /**
     * Prints the screen as a matrix.
     */
    public void drawGraphMatrix() {

        for(int i=0;i < this.getNumV();++i){
            for(int j=0; j < this.getNumV(); ++j ) {

                if((array2D)[i][j] == true)
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }
}
