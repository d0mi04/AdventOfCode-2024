package day_04;

import shared.DataSet;

public class Day04 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_04/input-04.txt");

        Part1(file);
        Part2(file);
    }

    public static void Part2(DataSet file) {
        LetterGrid letterGrid = new LetterGrid(file.getLines());
        WordSearch wordSearch = new WordSearch(letterGrid);

        int count = wordSearch.countXMASOccurrences();
        System.out.println(count);
    }

    public static void Part1(DataSet file) {
        LetterGrid letterGrid = new LetterGrid(file.getLines());
        WordSearch wordSearch = new WordSearch(letterGrid);

        String word = "XMAS";
        int count = wordSearch.countOccurrences(word);

        System.out.println(count);
    }
}
