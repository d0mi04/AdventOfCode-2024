package day_07;

import shared.DataSet;

public class Day07 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_07/input-07.txt");

        Part1(file);
    }

    public static void Part1(DataSet file) {
        long sum = 0;
        for(String line : file.getLines()) {
            Equation eq = new Equation(line);
            if(eq.findResult()) {
                sum+=eq.result;
            }
        }
        System.out.println(sum);
    }


}
