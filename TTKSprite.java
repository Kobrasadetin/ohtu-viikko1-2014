/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmaptottk;

import java.awt.image.BufferedImage;

/**
 *
 * @author mkarjanm
 */
public class TTKSprite {

    int[][] myData;
    String name;

    public TTKSprite(BufferedImage image, int xOffset, int yOffset, String name) {
        this.name=name;
        myData = new int[8][8];
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                int rgb, red, green, blue;
                rgb = image.getRGB(x+xOffset, y+yOffset);
                red = rgb >> 16 & 0xf0;
                green = rgb >> 8 & 0xf0;
                blue = rgb & 0xf0;
                myData[x][y] = (red << 8) | (green) | (blue >> 4);
            }
        }
    }

    @Override
    public String toString() {
        String output = new String();
        int c = 0;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                output+=name+c+" dc "+myData[x][y]+"\n";
                c++;
            }
        }
        return output;
    }
}
