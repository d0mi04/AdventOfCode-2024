package day_12;

import java.util.ArrayList;
import java.util.Stack;

public class GardenMap {
    ArrayList<String> map;
    ArrayList<Plant> plants;

    ArrayList<Region> regions;
    boolean[][] visited;

    public GardenMap(ArrayList<String> lines) {
        this.map = lines;
        this.plants = new ArrayList<>();

        this.regions = new ArrayList<>();
        this.visited = new boolean[map.size()][map.getFirst().length()];
    }

    public void CreatePlants() {
        for(int row = 0; row < map.size(); row++) {
            for(int col = 0; col < map.getFirst().length(); col++) {
                Plant plant = new Plant(getCharAt(row, col), col, row);
                plants.add(plant);
            }
        }
    }

    public void FindRegions() {
        for(int row = 0; row < map.size(); row++) {
            for(int col = 0; col < map.get(row).length(); col++) {
                if(!visited[row][col]) {
                    Region region = new Region();
                    ExploreRegion(row, col, map.get(row).charAt(col), region);
                    regions.add(region);
                }
            }
        }
    }

    public void ExploreRegion(int row, int col, char targetPlant, Region region) {
        // DFS implementation stack
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});

        while(!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            // is visited
            if(x < 0 || x >= map.size() || y < 0 || y >= map.get(x).length() || visited[x][y] || map.get(x).charAt(y) != targetPlant) {
                continue;
            }

            // mark as visited
            visited[x][y] = true;

            // add to region
            region.AddPlant(new Plant(map.get(x).charAt(y), x, y));

            stack.push(new int[]{x + 1, y}); // down
            stack.push(new int[]{x - 1, y}); // up
            stack.push(new int[]{x, y + 1}); // right
            stack.push(new int[]{x, y - 1}); // left
        }
    }

    public char getCharAt(int row, int col) {
        return map.get(row).charAt(col);
    }
}
