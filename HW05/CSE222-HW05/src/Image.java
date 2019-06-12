/*
 * Gokhan Has - 161044067
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This is the Image Class that reading Image and keeps its pixels as an array.
 * @author gokhanHas
 */
public class Image {
    /**
     * colorArray is 2D array to keeps myColor pixels.
     */
    private myColor[][] colorArray;

    /**
     * Constructor that read Image and assign Image's information to colorArray[][].
     */
    public Image() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/example.png"));
            colorArray = new myColor[img.getWidth()][img.getHeight()];

            for(int i=0;i<img.getWidth();++i) {
                for(int j=0;j<img.getHeight();++j) {
                    Color c = new Color(img.getRGB(i,j));
                    myColor color = new myColor(c.getRed(),c.getGreen(),c.getBlue());
                    colorArray[i][j] = color;
                }
            }
        } catch (IOException e) {
        }
    }

    /**
     *
     * @return 2D colorArray.
     */
    public myColor[][] getColorArray() {
        return colorArray;
    }
}

