package day_20;

import shared.DataSet;

public class Day20 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_20/input-20.txt");

        Part1(file);
    }

    public static void Part1(DataSet file){
        Race race = new Race(file);
//        System.out.println(race.racing());
        System.out.println(race.cheat());
    }
}
