package day_20;

import shared.DataSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Race {
    private final ArrayList<String> racetrack;

    public Race(DataSet file) {
        this.racetrack = new ArrayList<>(file.getLines());
    }

    public int cheat() {
        int path = racing();

        int cheets = 0;

        for(int row = 0; row < racetrack.size(); row++) {
            for(int col = 0; col < racetrack.getFirst().length(); col++) {
                if(racetrack.get(row).charAt(col) == '#') {
                    replaceChar(row, col, '.');

                    int newPath = racing();

                    if(newPath != -1 && newPath <= path - 100) {
                        cheets++;
                    }

                    replaceChar(row, col, '#');
                }
            }
        }
        return cheets;
    }

    public void replaceChar(int row, int col, char c) {
        StringBuilder sb = new StringBuilder(racetrack.get(row));
        sb.setCharAt(col, c);
        racetrack.set(row, sb.toString());
    }

    public int racing(){
        int[] start = findChar('S');
        int[] end = findChar('E');
        boolean[][] visited = new boolean[racetrack.size()][racetrack.getFirst().length()];
        int[][] directions = {
                {1, 0}, // down
                {-1, 0}, // up
                {0, 1}, // right
                {0, -1}, // left
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int steps = current[2];

            if(row == end[0] && col == end[1]) {
                return steps;
            }

            for(int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(isMoveValid(newRow, newCol) && !visited[newRow][newCol]) {
                    queue.add(new int[]{newRow, newCol, steps + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return -1;
    }

    public boolean isMoveValid(int row, int col) {
        if(row >= 0 && row < racetrack.size()
            && col >= 0 && col < racetrack.getFirst().length()
            && CharAt(row, col) != '#') {
            return true;
        }
        return false;
    }

    public int[] findChar(char c) {
        for(int row = 0; row < racetrack.size(); row++) {
            for(int col = 0; col < racetrack.getFirst().length(); col++) {
                if(racetrack.get(row).charAt(col) == c) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    public char CharAt(int row, int col) {
        return racetrack.get(row).charAt(col);
    }

    public ArrayList<String> getRacetrack() {
        return racetrack;
    }
}
