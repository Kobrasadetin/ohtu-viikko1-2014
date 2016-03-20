/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttk91graphics;

import java.util.ArrayList;

/**
 *
 * @author mkarjanm
 */
public class CodeBlock {

    int lines;

    ArrayList<String> lineArray;

    public int getLines() {
        return lines;
    }

    public ArrayList<String> getArray() {
        return lineArray;
    }

    public CodeBlock() {
        lineArray = new ArrayList();
        lines = 0;
    }
    public void addBlock(CodeBlock block) {
        lineArray.addAll(block.getArray());
        lines+=block.getLines();
    }

    public void createLine(String line) {
        lineArray.add(line);
        lines++;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String string : lineArray) {
            builder.append(string);
            if (!string.endsWith("\n")) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
