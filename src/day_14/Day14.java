package day_14;

import shared.DataSet;

public class Day14 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_14/input-14.txt");

        Part1(file);
        Part2(file);
    }

    public static void Part2(DataSet file) {
        Bathroom bathroom = new Bathroom(file);

        for(int i = 1; i < 10001; i++) { // 8270
            bathroom.Calculate();
            bathroom.ProduceImage();

            String filepath = "images/outut_" + i + ".jpg";
            bathroom.CreateImage(filepath);
        }
    }

    public static void Part1(DataSet file) {
        Bathroom bathroom = new Bathroom(file);

//        bathroom.PlaceRobots();
//        bathroom.printMap();
//        System.out.println();

        for(int i = 0; i < 100; i++) {
            bathroom.Calculate();
        }

        bathroom.PlaceRobots();
//        bathroom.printMap();

        System.out.println(bathroom.SafetyFactor());
    }
}
