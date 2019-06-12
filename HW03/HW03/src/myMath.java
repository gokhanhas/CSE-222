/*
 * Gokhan Has - 161044067
 */

/**
 * This is the myMath class to calculate mathematical functions
 * functions mentioned in the assignment (sin,cos,abs).
 */
public class myMath {
    /**
     * PI number
     */
    private static double myPI = 3.14159265;

    /**
     * Calculate absolute value.
     * @param value the number to be taken as the absolute value.
     * @return The distance to zero.
     */
    public static double myAbs(double value) {
        if(value < 0)
            return value*(-1);
        return value;
    }

    /**
     * Calculate Sine function by using Taylor series.
     * Calculated using 10 steps.
     * @param degree
     * @return the sin value.
     */
    public static double mySin(double degree) {

        double rad = (degree / 180.0) * myPI;
        int termNumber = 10;
        double result=0.0;

        for (int i=0;i<termNumber;i++)
            result += myPower(-1,i) * myPower(rad,2*i+1) / myFact(2*i+1);
        return result;
    }

    /**
     * Calculate Cosine function by using Taylor series.
     * Calculated using 10 steps.
     * @param degree
     * @return the cosine value.
     */
    public static double myCos(double degree) {
        double rad = (degree / 180.0) * myPI;
        int termNumber = 10;
        double result = 0.0;

        for (int i=0;i<termNumber;i++)
            result += myPower(-1,i) * myPower(rad,2*i) / myFact(2*i);
        return result;
    }

    /**
     * The first parameter entered takes its base in the second parameter.
     * @param n is a number.
     * @param pow is a integer number.
     * @return
     */
    public static double myPower(double n,int pow) {
        double result=1.0;
        for (int i=1;i<=pow;i++)
            result*=n;
        return result;
    }

    /**
     * Factorial calculations mathematically.
     * @param number
     * @return the factorial of the number.
     */
    public static double myFact(int number) {

        double result=1.0;
        for(int i=1;i<=number;++i)
            result*=i;
        return result;
    }
}
