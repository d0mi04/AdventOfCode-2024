package day_19;

import shared.DataSet;

public class Day19 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_19/input-19.txt");

        Part1(file);
        Part2(file);
    }

    public static void Part2(DataSet file) {
        Onsen onsen = new Onsen(file);
        System.out.println(onsen.countTotalCombinations());
    }

    public static void Part1(DataSet file) {
        Onsen onsen = new Onsen(file);
        System.out.println(onsen.countDesigns());
    }
}
