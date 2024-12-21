package day_12;

import shared.DataSet;

public class Day12 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_12/input-12.txt");

        Part1(file);
    }

    public static void Part1(DataSet file) {
        Garden garden = new Garden(file.getLines());
        garden.CreatePlants();

        garden.FindRegions();

        int TotalPrice = 0;
        for(Region r : garden.regions) {
            int price = r.CalculatePrice();
            TotalPrice+=price;
        }

        System.out.print(TotalPrice);
    }
}
