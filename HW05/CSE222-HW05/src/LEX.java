/*
 * Gokhan Has - 161044067
 */

import java.util.Comparator;

public class LEX implements Comparator<myColor> {
    @Override
    public int compare(myColor color1, myColor color2) {
        if(sortResult(color1.getRed(),color2.getRed()) == 0 && sortResult(color1.getGreen(),color2.getGreen()) == 0) {
            return sortResult(color1.getBlue(),color2.getBlue());
        }

        if(sortResult(color1.getRed(),color2.getRed()) == 0) {
            return sortResult(color1.getGreen(),color2.getGreen());
        }

        return sortResult(color1.getRed(),color2.getRed());
    }

    /**
     *
     * @param o1 is a double number.
     * @param o2 is an another double number.
     * @return 0 if the o1 and o2 are equal, 1 if the o1 > o2 and -1 if the o1 < o2.
     */
    private int sortResult(double o1,double o2) {
        if(o1 == o2)
            return 0;
        if(o1 > o2)
            return 1;

        return -1;
    }
}
