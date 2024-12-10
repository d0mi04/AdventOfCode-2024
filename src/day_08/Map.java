package day_08;

import java.util.ArrayList;

public class Map {
    ArrayList<String> lines;

    public Map(ArrayList<String> lines) {
        this.lines = lines;
    }

    public int getWidth() {
        return lines.getFirst().length();
    }

    public int getHeight() {
        return lines.size();
    }

    public char getCharAt(int row, int col) {
        return lines.get(row).charAt(col);
    }

    public boolean isOnMap(int row, int col) {
        return row >= 0 && row < getWidth() &&
                col >= 0 && col < getHeight();
    }
}
