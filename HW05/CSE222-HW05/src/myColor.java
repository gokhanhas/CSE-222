/*
 * Gokhan Has - 161044067
 */

/**
 * This is the myColor class to help the reading Image as a pixel.
 * @author gokhanHas
 */
public class myColor {
    /**
     * Keeps the red pixel as a integer.
     */
    private int redNumber;
    /**
     * Keeps the green pixel as a integer.
     */
    private int greenNumber;
    /**
     * Keeps the blue pixel as a integer.
     */
    private int blueNumber;

    /**
     * Constructor that initialize RGB pixels.
     * @param red is a redNumber.
     * @param green is a greenNumber.
     * @param blue is a blueNumber.
     */
    public myColor(int red,int green,int blue) {
        redNumber = red;
        greenNumber = green;
        blueNumber = blue;
    }

    public myColor(myColor other) {
        redNumber = other.getRed();
        greenNumber = other.getGreen();
        blueNumber = other.getBlue();
    }

    /**
     *
     * @return red pixel number.
     */
    public int getRed() { return redNumber; }

    /**
     *
     * @return green pixel number.
     */
    public int getGreen() { return greenNumber; }

    /**
     *
     * @return blue pixel number.
     */
    public int getBlue() { return blueNumber; }

    @Override
    public String toString() {
        return String.format("R : " + getRed() + "     G : " + getGreen() + "     B : " + getBlue());
    }
}
