package day_16;

import shared.DataSet;

public class Day16 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_16/test-16.txt");

        Part1(file);
    }

    public static void Part1(DataSet file) {
        Race race = new Race(file);

        race.findPath();

    }
}
