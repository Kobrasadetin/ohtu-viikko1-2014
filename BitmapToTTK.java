/*
 * c 2016 Mikko Karjanmaa
 */
package bitmaptottk;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author mkarjanm
 */
public class BitmapToTTK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    BufferedImage image = null;
    try {
            image = ImageIO.read(new File("kuva.bmp"));
        } catch (IOException e) {
    }

    TTKSprite sprite = new TTKSprite(image, 0, 0,"haa");
    System.out.println(sprite);
    sprite = new TTKSprite(image, 8, 0,"hab");
    System.out.println(sprite);
    sprite = new TTKSprite(image, 0, 8,"hac");
    System.out.println(sprite);
    sprite = new TTKSprite(image, 8, 8,"had");
    System.out.println(sprite);
    
    
    }
    
    
}
