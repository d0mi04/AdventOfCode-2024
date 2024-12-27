package day_17;

import shared.DataSet;

public class Day17 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_17/test-17.txt");

        Part1(file);
    }

    public static void Part1(DataSet file){
        Program program = new Program(file);

        program.runProgram();
    }
}
