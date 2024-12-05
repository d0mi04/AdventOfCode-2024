package day_03;

import shared.DataSet;

import java.util.ArrayList;

public class Day03 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_03/input-03.txt");

        Part1(file);
    }

    public static void Part1(DataSet file) {
        ArrayList<Program> programs = new ArrayList<>();
        for(String s : file.getLines()) {
            Program program = new Program(s);
            programs.add(program);
        }

        int sum = 0;
        for(Program p : programs) {
            sum+=p.sumResult();
        }

        System.out.println(sum);
    }
}
