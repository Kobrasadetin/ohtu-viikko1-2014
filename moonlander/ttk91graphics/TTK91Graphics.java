/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttk91graphics;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author mkarjanm
 */
public class TTK91Graphics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CodeBlock code = new CodeBlock();
        String ttkBinary = "moonlander_V003.b91";
        String imageFile = "tausta.bmp";
        String fontFile = "fonts.bmp";
        String outputFile = "output.b91";
        BufferedReader source = null;
        BufferedImage backgroundImage = null;
        BufferedImage fontImage = null;
        int[] fontAddr = new int[99];

        try {
            source = new BufferedReader(new FileReader(ttkBinary));
            backgroundImage = ImageIO.read(new File(imageFile));
            CodeBlock background = new TTKImage(backgroundImage, 160, 120, 0, 0, "bg").getCode();
            
            fontImage = ImageIO.read(new File(fontFile));

            CodeBlock fonts = new CodeBlock();
            for (int a=0; a<98; a++)
            {
                fonts.addBlock(new TTKImage(fontImage, 3, 6, a*4, 0, "font").getCode());
            }
            
            int graphicsSize = background.getLines()+fonts.getLines();

            while (true) {
                String line = source.readLine();
                if (line==null){break;}
                if (line.startsWith("___data___")) {
                    code.createLine(line);
                    line = source.readLine();
                    String[] values = line.split(" ");
                    int begin = Integer.parseInt(values[0]);
                    int end = Integer.parseInt(values[1])+1;
                    code.createLine(begin+" "+(8191+graphicsSize));
                    for (int x = 0; x < (end-begin); x++)
                    {
                        line = source.readLine();
                        code.createLine(line);
                    }
                    int range = 8192 - end;
                    
                    for (int x = 0; x < range; x++)
                    {
                        code.createLine("0");
                    }
                    code.addBlock(background);
                    code.addBlock(fonts);
                }else
                {
                    if (line.startsWith("___end___")) {//these are not actually used for much anything
                        for(int a=0;a<26;a++)
                        {
                            code.createLine("ascii"+(char)(65+a)+" "+(8192+background.getLines()+a*18));
                        }
                        for(int a=0;a<10;a++)
                        {
                            code.createLine("ascii"+(char)(48+a)+" "+(8192+background.getLines()+936+a*18));
                        }
                        code.createLine("ascii- "+(8192+background.getLines()+1134));
                        code.createLine(line);
                    }else{
                        code.createLine(line);
                    }
                }
            }

            FileWriter fileWriter
                    = new FileWriter(outputFile);

            BufferedWriter bufferedWriter
                    = new BufferedWriter(fileWriter);
            bufferedWriter.write(code.toString());
            bufferedWriter.close();
            //System.out.println(code);       
        } catch (IOException e) {
        }
        System.out.println("Succesfully wrote "+outputFile);
    }      
}
