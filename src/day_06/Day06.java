package day_06;

import shared.DataSet;

public class Day06 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_06/input-06.txt");

        Part1(file);
    }

    public static void Part1(DataSet file) {
        Navigator navigator = new Navigator(file);
        navigator.move();
        navigator.countX();
    }


}
