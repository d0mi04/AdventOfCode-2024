package day_12;

import shared.DataSet;

public class Day12 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_12/input-12.txt");

        Part1(file);
    }

    public static void Part1(DataSet file) {
        GardenMap map = new GardenMap(file.getLines());
        map.CreatePlants();

        map.FindRegions();

        int TotalPrice = 0;
        for(Region r : map.regions) {
            int price = r.CalculatePrice();
            TotalPrice+=price;
        }

        System.out.print(TotalPrice);
    }
}
