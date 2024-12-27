package day_18;

import shared.DataSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solver {
    Map map;
    ArrayList<int[]> path;

    boolean[][] visited;

    public Solver(DataSet file) {
        this.map = new Map(file);
        this.path = new ArrayList<>();

        this.visited = new boolean[map.getHEIGHT()][map.getWIDTH()];
    }

    // start is [0, 0], end is [70, 70]
    public void countSteps(int[] start, int[] end) {
        int[][] directions = {
                {1, 0}, //down
                {-1, 0}, // up
                {0, 1}, // right
                {0, -1} // left
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0}); // row, col, steps

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int steps = current[2];

            // end was find
            if(row == end[0] && col == end[1]) {
                System.out.println("Steps: " + steps);
                return;
            }

            visited[row][col] = true;

            // check neighbours
            for(int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(isMoveValid(newRow, newCol)) {
                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol, steps + 1});
                }
            }
        }
    }

    // move[0] - Y/row, move[1] - X/col
    public boolean isMoveValid(int row, int col) {
        return row >= 0 && row < map.getHEIGHT() &&
                col >= 0 && col < map.getWIDTH() &&
                map.grid[row][col] != 1 &&
                !visited[row][col];
    }
}
