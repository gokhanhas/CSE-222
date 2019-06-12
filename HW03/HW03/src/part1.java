/*
 * Gokhan Has - 161044067
 */

import java.io.*;

/**
 * This is the part1.java class to calculate white component in a file.
 * @author gokhanHas
 */
public class part1 {

    /**
     * This is the helper class to keep
     * matrix element position.
     */
    private class Point {
        /**
         * Keeps the x_coordinate.
         */
        int pos_x;

        /**
         * Keeps the y_coordinate.
         */
        int pos_y;

        /**
         * The constructor that create Point class object.
         * @param x the x coordinate.
         * @param y the y coordinate.
         */
        public Point(int x,int y) {

            pos_x = x;
            pos_y = y;
        }

        /**
         * The get methods for x coordinate.
         * @return the x coordinate.
         */
        public int getPos_x() {
            return  pos_x;
        }

        /**
         * The get methods for y coordinate.
         * @return the y coordinate.
         */
        public int getPos_y() {
            return pos_y;
        }
    }

    /**
     * This method get the matrix from the file.
     * This matrix integer also holds a two-dimensional array.
     * Prints the white compenent number on the screen.
     */
    public void readedFile() {

        myStack<Integer> tempStack = new myStack<Integer>();
        int i=0,j=0;
        try {
            BufferedReader inputFile = new BufferedReader(new FileReader("src\\test_file_part1.txt"));
            String line;
            while ((line = inputFile.readLine()) != null)
            {
                j=0;
                String[] lineChars = line.split(" ");
                for (String str : lineChars) {
                    int value = Integer.parseInt(str);
                    tempStack.push(value);
                    j++;
                }
                i++;
            }
            inputFile.close();

            int[][] array2D = new int[i][j];
            // Its O(n) .... n is number of matrix elements
            for(int a = i-1; a >= 0; a--) {
                for(int b=j-1; b >= 0; b--) {
                    array2D[a][b] = tempStack.pop();
                }
            }

            myStack<Point> countStack = new myStack<Point>();
            int count = 0;
            // Its O(n) .... n is number of matrix elements
            for(int a=0; a<i; ++a) {
                for(int b=0; b<j; b++) {

                    if(array2D[a][b] == 1) {
                        Point currentPoint = new Point(a,b);
                        countStack.push(currentPoint);

                        while(!countStack.empty()) {

                            int tempX = countStack.peek().getPos_x();
                            int tempY = countStack.peek().getPos_y();
                            boolean control = false;

                            if(tempY-1 != -1) { // looking left

                                if(array2D[tempX][tempY-1] == 1) {
                                    control = true;
                                    array2D[tempX][tempY-1] = 0;
                                    countStack.push(new Point(tempX,tempY-1));
                                }
                            }

                            if(tempX+1 != i) { // looking right

                                if(array2D[tempX+1][tempY] == 1) {
                                    control = true;
                                    array2D[tempX+1][tempY] = 0;
                                    countStack.push(new Point(tempX+1,tempY));
                                }
                            }

                            if(tempY+1 != j) { // looking down

                                if(array2D[tempX][tempY+1] == 1) {
                                    control = true;
                                    array2D[tempX][tempY+1] = 0;
                                    countStack.push(new Point(tempX,tempY+1));
                                }
                            }

                            if(tempX-1 != -1) { // looking up

                                if(array2D[tempX-1][tempY] == 1) {
                                    control = true;
                                    array2D[tempX-1][tempY] = 0;
                                    countStack.push(new Point(tempX-1,tempY));
                                }
                            }

                            if(control == false) {
                                countStack.pop();
                            }
                        }
                        count++;
                    }
                }
            }
            System.out.println("White Component Count --> " + count);

        }catch( IOException ioException ) {
            System.out.println("Error! File is not found !");
        }
    }

    /**
     * This method has been written to test the readedFile method.
     * It calls this method.
     */
    public void Test() {
        this.readedFile();
    }
}