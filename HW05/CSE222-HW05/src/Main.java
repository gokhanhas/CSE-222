/*
 * Gokhan Has - 161044067
 */

public class Main {

    public static void main(String[] args) {

        Image myImage = new Image();

        myThreads threads = new myThreads(myImage.getColorArray());
        threads.runTreads();

    }
}
