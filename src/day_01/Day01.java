package day_01;

import shared.DataSet;

public class Day01 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_01/input-01.txt");

        Part1(file);
        Part2(file);
    }

    public static void Part1(DataSet file) {
        Lists lists = new Lists(file);
        lists.SortLists();
        int sum = lists.countDistance();
        System.out.println(sum);
    }

    public static void Part2(DataSet file) {
        Lists lists = new Lists(file);
        lists.SortLists();
        int sum = lists.countOccurance();
        System.out.println(sum);
    }
}
