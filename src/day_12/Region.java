package day_12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Region {
    // define neighbours:
    private static final int[][] directions = {
            {-1, 0}, // up
            {1, 0}, // down
            {0, -1}, // left
            {0, 1} // right
    };
    ArrayList<Plant> plants;

    public Region() {
        plants = new ArrayList<>();
    }

    public void AddPlant(Plant plant) {
        plants.add(plant);
    }

    public int CalculatePrice() {
        return CalculateArea() * CalculatePerimeter();
    }


    public int CalculatePerimeter() {
        Set<Plant> region = new HashSet<>(plants);
        int perimeter = 0;

        for(Plant p : plants) {
            int plantPerimeter = 4;

            for(int[] dir : directions) {
                int neighbourX = p.getX() + dir[0];
                int neighbourY = p.getY() + dir[1];

                if(region.contains(new Plant(' ', neighbourX, neighbourY))) {
                    plantPerimeter--;
                }
            }

            perimeter += plantPerimeter;
        }

        return perimeter;
    }

    public int CalculateArea() {
        return plants.size();
    }
}
