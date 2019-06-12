/*
 * Gokhan Has - 161044067
 */

public class myThreads extends Thread{

    LEX lex = new LEX();
    EUC euc = new EUC();
    BMX bmx = new BMX();

    private myPriorityQueue PQLEX = new myPriorityQueue(lex);
    private myPriorityQueue PQEUC = new myPriorityQueue(euc);
    private myPriorityQueue PQBMX = new myPriorityQueue(bmx);
    private myColor[][] colorArr;

    public myThreads(myColor[][] colorArray) {
        colorArr = colorArray;
    }

    public void runTreads() {

        Thread thread1 = new Thread(new Runnable(){
            @Override

            public void run() {
                try {
                    int counter = 0;

                    for (int i = 0; i < colorArr.length; ++i) {
                        for (int j = 0; j < colorArr[0].length; ++j) {

                            PQLEX.offer(colorArr[i][j]);
                            PQEUC.offer(colorArr[i][j]);
                            PQBMX.offer(colorArr[i][j]);
                            System.out.println("Thread 1: [" + colorArr[i][j].getRed() + ", " + colorArr[i][j].getGreen()
                                    + ", " + colorArr[i][j].getBlue() + "]");

                            if (counter >= 100) {

                                Thread thread2 = new Thread(new Runnable() {

                                    @Override
                                    public void run() {
                                        try {
                                            myColor deletedColor = new myColor(PQLEX.remove());
                                            System.out.println("Thread2-PQLEX: [" + deletedColor.getRed() + ", " + deletedColor.getGreen()
                                                    + ", " + deletedColor.getBlue() + "]");
                                        } catch (Exception e) {
                                        }
                                    }
                                });
                                thread2.start();

                                Thread thread3 = new Thread(new Runnable() {

                                    @Override
                                    public void run() {
                                        try {
                                            myColor deletedColor = new myColor(PQEUC.remove());
                                            System.out.println("Thread3-PQEUC: [" + deletedColor.getRed() + ", " + deletedColor.getGreen()
                                                    + ", " + deletedColor.getBlue() + "]");
                                        } catch (Exception e) {

                                        }


                                    }
                                });
                                thread3.start();

                                Thread thread4 = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            myColor deletedColor = new myColor(PQBMX.remove());
                                            System.out.println("Thread4-PQBMX: [" + deletedColor.getRed() + ", " + deletedColor.getGreen()
                                                    + ", " + deletedColor.getBlue() + "]");
                                        } catch (Exception e) {

                                        }

                                    }
                                });
                                thread4.start();

                            }
                            counter++;
                        }
                    }
                }catch (Exception e) {

                }
            }
        });

        thread1.start();
    }
}
