package day_18;

import shared.DataSet;

import java.util.ArrayList;

public class Map {
    private static final int WIDTH = 71; // test: 7, input: 71
    private static final int HEIGHT = 71; //test: 7, input: 71

    int[][] grid;
    private ArrayList<int[]> fallingBytes;

    public Map(DataSet file) {
        this.grid = new int[HEIGHT][WIDTH];
        fillGrid();
        createBytes(file);
        setOnMap();
    }

    public void setOnMap() {
        System.out.println(fallingBytes.size());
        for(int i = 0; i < 1024; i++) { // test: 12, input: 1024
            setCell(fallingBytes.get(i), 1);
        }
    }

    public void createBytes(DataSet file) {
        fallingBytes = new ArrayList<>();
        for(String s : file.getLines()) {
            String[] split = s.split(",");
            // byte in file is X,Y -> in program use row,col
            fallingBytes.add(new int[]{Integer.parseInt(split[1]), Integer.parseInt(split[0])});
        }
    }

    public void fillGrid() {
        for(int row = 0; row < HEIGHT; row++) {
            for(int col = 0; col < WIDTH; col++) {
                grid[row][col] = 0;
            }
        }
    }

    public void setCell(int[] pos, int sym) {
        grid[pos[0]][pos[1]] = sym;
    }

    public int getWIDTH(){
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
