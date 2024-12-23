package day_16;

import shared.DataSet;

import java.util.ArrayList;
import java.util.Stack;

public class Race {
    private final Map map;
    boolean[][] visited;
    ArrayList<int[]> shortestPath;

    public Race(DataSet file) {
        this.map = new Map(file);
        this.visited = new boolean[map.getMap().size()][map.getMap().getFirst().length()];
        this.shortestPath = new ArrayList<>();
    }

    public void printPath(ArrayList<int[]> path) {
        System.out.println("Steps: " + path.size());
        for(int[] step : path) {
            System.out.println("X: " + step[0] + ", Y: " + step[1]);
        }
    }

    public void findPath(){
        int[] start = map.findLetter('S');
        int[] end = map.findLetter('E');

        shortestPath = DFS(start, end);
        printPath(shortestPath);
    }

    public ArrayList<int[]> DFS(int[] start, int[] end) {
        Stack<int[]> stack = new Stack<>();

        ArrayList<int[]> currentPath = new ArrayList<>();

        int[][] directions = {
                {1, 0}, // down
                {-1, 0}, // up
                {0, -1}, // left
                {0, 1} // right
        };

        stack.push(start);

        while(!stack.isEmpty()) {
            int[] currentStep = stack.pop();

            // if cell was already visited, go to next cell
            if(!isMoveValid(currentStep[0], currentStep[1])) {
                continue;
            }

            visited[currentStep[0]][currentStep[1]] = true;
            currentPath.add(currentStep);

            // if end was found
            if(currentStep[0] == end[0] && currentStep[1] == end[1]) {
                if(currentPath.size() < shortestPath.size()) {
                    shortestPath = new ArrayList<>(currentPath); // found path is now the shortest path
                }
            }

            // check neighbours
            for (int[] dir : directions) {
                int newRow = currentStep[1] + dir[1];
                int newCol = currentStep[0] + dir[0];

                if (isMoveValid(newRow, newCol)) {
                    stack.push(new int[]{newRow, newCol});
                }
            }

            currentPath.removeLast();
        }

        return shortestPath;
    }

    public boolean isMoveValid(int row, int col) {
        if(row >= 0 && row < map.getMap().size()
            && col >= 0 && col < map.getMap().getFirst().length()
            && !visited[row][col] && map.getCharAt(row, col) != '#') {
            return true;
        }
        return false;
    }

    public Map getMap(){
        return map;
    }
}
