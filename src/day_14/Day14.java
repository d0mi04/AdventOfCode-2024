package day_14;

import shared.DataSet;

public class Day14 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_14/input-14.txt");

        Part1(file);
    }

    public static void Part1(DataSet file) {
        Bathroom bathroom = new Bathroom(file);

        bathroom.PlaceRobots();
//        bathroom.printMap();
//        System.out.println();

        bathroom.Calculate();
        bathroom.PlaceRobots();
//        bathroom.printMap();

        System.out.println(bathroom.SafetyFactor());
    }
}
