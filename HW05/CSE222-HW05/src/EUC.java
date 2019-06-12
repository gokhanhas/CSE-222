/*
 * Gokhan Has - 161044067
 */

import java.util.Comparator;

public class EUC implements Comparator<myColor> {
    @Override
    public int compare(myColor color1, myColor color2) {
        double distance1 = Math.sqrt((double)(Math.pow((double)color1.getRed(),2.0) + Math.pow((double)color1.getGreen(),2.0)
                + Math.pow((double)color1.getBlue(),2.0)));
        double distance2 = Math.sqrt((double)(Math.pow((double)color2.getRed(),2.0) + Math.pow((double)color2.getGreen(),2.0)
                + Math.pow((double)color2.getBlue(),2.0)));

        return sortResult(distance1,distance2);
    }

    /**
     *
     * @param o1 is a double number.
     * @param o2 is an another double number.
     * @return 0 if the o1 and o2 are equal, 1 if the o1 > o2 and 2 if the o1 < o2.
     */
    private int sortResult(double o1,double o2) {
        if(o1 == o2)
            return 0;
        if(o1 > o2)
            return 1;

        return -1;
    }
}
