package day_15;

import shared.DataSet;

public class Day15 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_15/test-15.txt");

        Part1(file);
    }

    public static void Part1(DataSet file) {
        Warehouse warehouse = new Warehouse(file);
        warehouse.moveRobot();
    }
}
