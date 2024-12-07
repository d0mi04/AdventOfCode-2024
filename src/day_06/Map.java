package day_06;

import java.util.ArrayList;

public class Map {
    ArrayList<String> map;

    public Map(ArrayList<String> lines) {
        this.map = lines;
    }

    public void drawX(int[] pos) {
        String line = map.get(pos[0]);
        StringBuilder sb = new StringBuilder(line);
        sb.setCharAt(pos[1], 'X');

        map.set(pos[0], sb.toString());
    }

    public boolean isObstruction(int[] pos) {
        return getCharAt(pos) == '#';
    }

    public int getRows() {
        return map.size();
    }

    public int getColumns() {
        return map.getFirst().length();
    }

    public char getCharAt(int[] pos) {
        return map.get(pos[0]).charAt(pos[1]);
    }
}
