/*
 * Gokhan Has - 161044067
 */

public class Main {

    public static void main(String[] args) {

        System.out.print("Test 1 --> ");
        int[][] array2D = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        myIterator newIterator = new myIterator(array2D);
        newIterator.showSpiral(0);

        System.out.println("\n");

        System.out.print("Test 2 --> ");
        int[][] array2D2 = new int[][]{{1, 2, 3, 4,13},
                {5, 6, 7, 8,14},
                {9, 10, 11, 12,15}
        };

        myIterator newIterator2 = new myIterator(array2D2);
        newIterator2.showSpiral(0);

        System.out.println("\n");

        System.out.print("Test 3 --> ");
        int[][] array2D3 = new int[][]{
                {1, 2, 3,19},
                {4,5,6,20},
                {7,8,9,21},
                {10,11,12,22},
                {13,14,15,23},
                {16,17,18,24}
        };

        myIterator newIterator3 = new myIterator(array2D3);
        newIterator3.showSpiral(0);

        System.out.println("\n");

        System.out.print("Test 4 --> ");
        int[][] array2D4 = new int[][]{{ 1, 2, 3, 19, 25,26},
                                        {4, 5, 6, 20, 27,28},
                                        {7, 8, 9, 21, 29,30},
                                        {10,11,12,22, 31,32},
                                        {13,14,15,23, 33,34},
                                        {16,17,18,24, 35,36}
        };

        myIterator newIterator4 = new myIterator(array2D4);
        newIterator4.showSpiral(0);

        System.out.println("\n");

        System.out.print("Test 5 --> ");
        int[][] array2D5 = new int[][]{
                { 1, 2, 3, 19, 25,26,37},
                {4, 5, 6, 20, 27,28,39},
                {7, 8, 9, 21, 29,30,41},
                {10,11,12,22, 31,32,43},
                {13,14,15,23, 33,34,45},
                {16,17,18,24, 35,36,47},
                {49,50,51,52,53,54,55}
        };

        myIterator newIterator5 = new myIterator(array2D5);
        newIterator5.showSpiral(0);
    }
}
