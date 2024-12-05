package day_04;

import java.util.ArrayList;

public class LetterGrid {
    ArrayList<String> lines;

    public LetterGrid(ArrayList<String> lines) {
        this.lines = lines;
    }

    public int getRows() {
        return lines.size();
    }

    public int getColumns() {
        return lines.getFirst().length();
    }

    public char getCharAt(int row, int column) {
        return lines.get(row).charAt(column);
    }
}
