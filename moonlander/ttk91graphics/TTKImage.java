/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttk91graphics;

import java.awt.image.BufferedImage;

/**
 *
 * @author mkarjanm
 */
public class TTKImage {

    int[][] myData;
    String name;
    int xDim;
    int yDim;

    public TTKImage(BufferedImage image, int xSize, int ySize, int xOffset, int yOffset, String name) {
        this.name = name;
        xDim = xSize;
        yDim = ySize;
        myData = new int[xSize][ySize];
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                int rgb, red, green, blue;
                rgb = image.getRGB(x + xOffset, y + yOffset);
                red = int16to8((rgb >> 16) & 0xff);
                green = int16to8((rgb >> 8) & 0xff);
                blue = int16to8(rgb & 0xff);
                myData[x][y] = (red << 8) | (green << 4) | (blue);
            }
        }
    }

    static int int16to8(int channelColor) {
        return channelColor / 16;
    }

    public CodeBlock getCode() {
        CodeBlock code = new CodeBlock();
        for (int y = 0; y < yDim; y++) {
            for (int x = 0; x < xDim; x++) {
                code.createLine(String.valueOf(myData[x][y]));
            }
        }
        return code;
    }

    @Override
    public String toString() {
        String output = new String();
        int c = 0;
        for (int y = 0; y < yDim; y++) {
            for (int x = 0; x < xDim; x++) {
                output += name + c + " dc " + myData[x][y] + "\n";
                c++;
            }
        }
        return output;
    }
}
