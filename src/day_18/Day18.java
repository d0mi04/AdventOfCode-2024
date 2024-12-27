package day_18;

import shared.DataSet;

public class Day18 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/day_18/input-18.txt");

        Solver solver = new Solver(file);
        solver.countSteps(new int[]{0, 0}, new int[]{70, 70});
    }
}
