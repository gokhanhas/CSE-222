/*
 * Gokhan Has - 161044067
 */

import java.util.Iterator;

/**
 * This is the myIterator class to find spiral Array.
 * @author Gokhan
 */
public class myIterator implements Iterable<Integer>, Iterator<Integer> {
    /**
     * keeps matrix.
     */
    private int[][] array2D;
    /**
     * keeps matrix's x position.
     */
    private int pos_x;
    /**
     * keeps matrix's y position.
     */
    private int pos_y;
    /**
     * keeps mtrix's size.
     */
    private int size;
    /**
     * keeps size again used in code.
     */
    private int countSize;
    /**
     * necessary to recursive method's base case.
     */
    private int controlNumber;
    /**
     * keeps the right-left move.
     */
    private int controlX;
    /**
     * keeps the up-down move.
     */
    private int controlY;

    private int control = -1;
    private int control2 = -1;

    /**
     * It is constructor.
     * @param tempArray2D is the matrix.
     */
    public myIterator(int[][] tempArray2D) {

        array2D = tempArray2D;
        pos_x = 0;
        controlX = array2D[0].length;
        controlNumber = 0;
        controlY = array2D.length;
        size = controlX*controlY;
        countSize = size;
    }

    /**
     *
     * @return iterator.
     */
    @Override
    public Iterator iterator() {
        return this;
    }

    /**
     *
     * @return true if the iterator has more element.
     */
    @Override
    public boolean hasNext() {
        return (controlNumber < size);
    }

    /**
     * It is iterator next method recursively.
     * @return the matrix element.
     */
    @Override
    public Integer next() {

        if( controlNumber % 4 == 0) {

            if(pos_y == controlX - 1) {
                controlNumber++;
            }
            else{
                pos_y++;
                countSize--;
                return array2D[pos_x][pos_y-1];
            }
        }

        else if(controlNumber % 4 == 1) {

            if(pos_x == controlY - 1) {
                controlNumber++;
                control++;
            }
            else{
                pos_x++;
                countSize--;
                return array2D[pos_x-1][pos_y];
            }
        }

        else if(controlNumber % 4 == 2) {

            if(controlX - pos_y + control == controlX ) {
                controlX--;
                controlNumber++;
                control2++;
            }
            else {
                pos_y--;
                countSize--;
                return array2D[pos_x][pos_y+1];
            }
        }

        else if(controlNumber % 4 == 3) {

            if(pos_x  ==  control2+1) {
                controlY--;
                controlNumber++;

            }
            else {
                pos_x--;
                countSize--;
                return array2D[pos_x+1][pos_y];
            }
        }

        else {
            controlNumber++;
        }

        return next();
    }

    /**
     * showSpiral method is recursive method to print the matrix elements.
     * @param count is zero.
     */
    public void showSpiral(int count) {

        if(count < this.size){
            count++;
            System.out.print(next() + " ");
            showSpiral(count);
        }
    }
}