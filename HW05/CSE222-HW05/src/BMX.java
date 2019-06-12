/*
 * Gokhan Has - 161044067
 */

import java.util.Comparator;

public class BMX implements Comparator<myColor> {
    @Override
    public int compare(myColor color1, myColor color2) {
        int[] redArray = new int[8],redArray2 = new int[8];
        int[] greenArray = new int[8],greenArray2 = new int[8];
        int[] blueArray = new int[8],blueArray2 = new int[8];

        redArray = convertBinary(color1,1);
        greenArray = convertBinary(color1,2);
        blueArray = convertBinary(color1,3);

        redArray2 = convertBinary(color2,1);
        greenArray2 = convertBinary(color2,2);
        blueArray2 = convertBinary(color2,3);

        String colorStr1 = new String();
        String colorStr2 = new String();
        int i=0;

        while(i<8){
            colorStr1 += redArray[i];
            colorStr1 += greenArray[i];
            colorStr1 += blueArray[i];

            colorStr2 += redArray2[i];
            colorStr2 += greenArray2[i];
            colorStr2 += blueArray2[i];

            i++;
        }

        int number1 = Integer.parseInt(colorStr1,2);
        int number2 = Integer.parseInt(colorStr2,2);

        return sortResult(number1,number2);
    }

    private int[] convertBinary(myColor color,int which) {

        int number = 0;
        int[] returnArr = new int[8];
        switch (which) {
            case 1: number = color.getRed();    break;
            case 2: number = color.getGreen();  break;
            case 3: number = color.getBlue();   break;
            default: break;
        }

        int i=7;
        while (number > 0){
            returnArr[i] = number%2;
            i--;
            number /= 2;
        }

        while (i >= 0) {
            returnArr[i] = 0;
            i--;
        }
        return returnArr;
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