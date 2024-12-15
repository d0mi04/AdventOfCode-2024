package day_09;

import shared.OneLineInput;

public class Day09 {
    public static void main(String[] args) {
        OneLineInput line = new OneLineInput("src/day_09/test-09.txt");

        Part1(line);
    }

    public static void Part1(OneLineInput line) {

        FileSystem fileSystem = new FileSystem(line);
        fileSystem.printFileSystem();
        fileSystem.RemoveGaps();
        fileSystem.printFileSystem();
        fileSystem.CountChecksum();
    }
}
