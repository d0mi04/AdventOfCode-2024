package day_11;

import shared.DataSet;

public class Day11 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_11/input-11.txt");

        Part1(file);
    }
    public static void Part1(DataSet file) {
        Navigator navigator = new Navigator(file);

        for(int i = 0; i < 25; i++) {
            navigator.CheckStones();
        }

        System.out.print(navigator.stones.size());
    }
}
